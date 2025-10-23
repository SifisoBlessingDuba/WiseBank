package za.ac.cput.wisebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.domain.Withdrawal;
import za.ac.cput.wisebank.domain.WithdrawalStatus;
import za.ac.cput.wisebank.repository.AccountRepository;
import za.ac.cput.wisebank.repository.WithdrawalRepository;
import java.time.LocalDateTime;


@Service
public class WithdrawalService  {

    private final WithdrawalRepository withdrawalRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public WithdrawalService(WithdrawalRepository withdrawalRepository, AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.withdrawalRepository = withdrawalRepository;
    }


    @Transactional
    public Withdrawal withdrawMoney(User user, Account account, double amount, String phoneNumber) {
        // Basic validations
        if (user == null || account == null) {
            throw new IllegalArgumentException("User and Account are required");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero");
        }
        if (account.getAccountBalance() < amount){
            throw new IllegalArgumentException("Insufficient Funds");
        }

        // Deduct and persist the new balance immediately
        account.setAccountBalance(account.getAccountBalance() - amount);
        accountRepository.saveAndFlush(account);

        // Create and persist the withdrawal record
        Withdrawal withdrawal = new Withdrawal.Builder()
                .setUser(user)
                .setAccount(account)
                .setAmount(amount)
                .setRecipientPhoneNumber(phoneNumber)
                .setWithdrawalDate(LocalDateTime.now())
                .setWithdrawalStatus(WithdrawalStatus.SUCCESS)
                .build();
        return withdrawalRepository.save(withdrawal);
    }
}
//guys check if this page will show up in the final project
//74