package za.ac.cput.wisebank.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.domain.Withdrawal;
import za.ac.cput.wisebank.domain.WithdrawalStatus;
import za.ac.cput.wisebank.factory.WithdrawalFactory;
import za.ac.cput.wisebank.repository.AccountRepository;
import za.ac.cput.wisebank.repository.WithdrawalRepository;
import java.time.LocalDateTime;
import java.util.List;

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
        if (account.getAccountBalance() < amount){
            throw new IllegalArgumentException("Insufficient Funds");
        }

        account.setAccountBalance(account.getAccountBalance() - amount);
        accountRepository.save(account);

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
