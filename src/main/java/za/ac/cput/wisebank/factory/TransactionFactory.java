package za.ac.cput.wisebank.factory;

import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Transaction;
import za.ac.cput.wisebank.util.Helper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionFactory {
    public static Transaction createTransaction(Integer transactionId, Account senderAccount,
                                                BigDecimal amount, String transactionType,
                                                LocalDateTime timestamp, String description,
                                                String status) {
        if(
                !Helper.isValidInt(transactionId) ||
                senderAccount == null ||
                amount == null || amount.compareTo(BigDecimal.ZERO) <= 0 ||
                Helper.isNullOrEmpty(transactionType) ||
                timestamp == null ||
                Helper.isNullOrEmpty(description) ||
                Helper.isNullOrEmpty(status)
        ) {
            return null;
        }

        return new Transaction.Builder()
                .setTransactionId(transactionId)
                .setSenderAccount(senderAccount)
                .setAmount(amount)
                .setTransactionType(transactionType)
                .setTimestamp(timestamp)
                .setDescription(description)
                .setStatus(status)
                .build();
    }
}
