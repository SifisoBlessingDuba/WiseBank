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
        System.out.println("Received withdrawal request: " + request);

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        // Security: Ensure the account belongs to the user
        if (!account.getUser().getIdNumber().equals(user.getIdNumber())) {
            return ResponseEntity.badRequest().body("Account does not belong to the user");
        }

        Withdrawal withdrawal = withdrawalService.withdrawMoney(
                user,
                account,
                request.getAmount(),
                request.getPhoneNumber()
        );


        WithdrawalResponse response = new WithdrawalResponse(
                account.getAccountNumber(),
                request.getAmount(),
                account.getAccountBalance(),
                withdrawal.getWithdrawalStatus().name(),
                withdrawal.getWithdrawalDate()
        );

        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
