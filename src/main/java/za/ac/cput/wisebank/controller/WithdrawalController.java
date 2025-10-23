package za.ac.cput.wisebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.wisebank.domain.*;
import za.ac.cput.wisebank.dto.*;
import za.ac.cput.wisebank.repository.*;
import za.ac.cput.wisebank.service.*;

@RestController
@RequestMapping("/withdrawals")
public class WithdrawalController {

    private final WithdrawalService withdrawalService;
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public WithdrawalController(
            WithdrawalService withdrawalService,
            AccountRepository accountRepository,
            UserRepository userRepository) {
        this.withdrawalService = withdrawalService;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }


    @PostMapping
    public ResponseEntity<?> makeWithdrawal(@RequestBody WithdrawalRequest request) {
        if(request.getUserId() == null || request.getUserId().isEmpty()) {
            return ResponseEntity.badRequest().body("User ID is required");
        }
        if(request.getAccountId() == null || request.getAccountId().isEmpty()) {
            return ResponseEntity.badRequest().body("Account ID is required");
        }
        if (request.getPhoneNumber() == null || request.getPhoneNumber().isEmpty()) {
            return ResponseEntity.badRequest().body("Phone number is required");
        }
        if (request.getAmount() <= 0) {
            return ResponseEntity.badRequest().body("Amount must be greater than zero");
        }
        System.out.println("[WithdrawalController] Incoming request: userId=" + request.getUserId()
                + ", accountId=" + request.getAccountId()
                + ", phone=" + request.getPhoneNumber()
                + ", amount=" + request.getAmount());

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        // Security: Ensure the account belongs to the user
        if (!account.getUser().getIdNumber().equals(user.getIdNumber())) {
            System.err.println("[WithdrawalController] Account ownership mismatch: userId=" + user.getIdNumber()
                    + ", accountId=" + account.getAccountNumber());
            return ResponseEntity.badRequest().body("Account does not belong to the user");
        }

        System.out.println("[WithdrawalController] Attempting withdrawal: currentBalance=" + account.getAccountBalance()
                + ", amount=" + request.getAmount());

        try {
            Withdrawal withdrawal = withdrawalService.withdrawMoney(
                    user,
                    account,
                    request.getAmount(),
                    request.getPhoneNumber()
            );

            System.out.println("[WithdrawalController] Withdrawal SUCCESS: withdrawalId=" + withdrawal.getWithdrawalId()
                    + ", newBalance=" + account.getAccountBalance());

            WithdrawalResponse response = new WithdrawalResponse(
                    account.getAccountNumber(),
                    request.getAmount(),
                    account.getAccountBalance(),
                    withdrawal.getWithdrawalStatus().name(),
                    withdrawal.getWithdrawalDate()
            );

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException ex) {
            System.err.println("[WithdrawalController] Withdrawal FAILED for userId=" + request.getUserId()
                    + ", accountId=" + request.getAccountId()
                    + ", amount=" + request.getAmount()
                    + ": " + ex.getMessage());
            throw ex; // will be handled by the @ExceptionHandler below
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        System.err.println("[WithdrawalController] Error response: " + ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
//guys check if this page will show up in the final project
//16