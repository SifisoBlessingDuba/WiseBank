package za.ac.cput.wisebank.factory;

import org.springframework.stereotype.Component;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.domain.Withdrawal;
import za.ac.cput.wisebank.domain.WithdrawalStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
public class WithdrawalFactory {

    public static Withdrawal createWithdrawal(User user, Account account,
                                                          double amount, LocalDateTime withdrawalDate,
                                                          WithdrawalStatus withdrawalStatus, String recipientPhoneNumber,
                                                          LocalDateTime createdAt, LocalDateTime updatedAt
                                                          ) {
        return new Withdrawal.Builder()
                .setUser(user)
                .setAccount(account)
                .setAmount(amount)
                .setWithdrawalDate(withdrawalDate)
                .setWithdrawalStatus(withdrawalStatus)
                .setRecipientPhoneNumber(recipientPhoneNumber)
                .setCreatedAt(createdAt)
                .setUpdatedAt(updatedAt)
                .build();
    }
}
//guys check if this page will show up in the final project
//40
