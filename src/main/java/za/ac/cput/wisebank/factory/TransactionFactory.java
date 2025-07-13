package za.ac.cput.wisebank.factory;

import org.springframework.stereotype.Component;
import za.ac.cput.wisebank.domain.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Component
public class TransactionFactory {
    public static Transaction createTransaction(Long transactionId, Long senderAccountId, BigDecimal amount,
                                                String transactionType, LocalDateTime timestamp, String description,
                                                String status) {

        return new Transaction.Builder()
                .setTransactionId(transactionId)
                .setSenderAccountId(senderAccountId)
                .setAmount(amount)
                .setTransactionType(transactionType)
                .setTimestamp(timestamp)
                .setDescription(description)
                .setStatus(status)
                .build();
    }

    public static Transaction createTransaction(Long transactionId, Long senderAccountId, BigDecimal amount,
                                                String transactionType, LocalDateTime timestamp) {
        return new Transaction.Builder()
                .setTransactionId(transactionId)
                .setSenderAccountId(senderAccountId)
                .setAmount(amount)
                .setTransactionType(transactionType)
                .setTimestamp(timestamp)
                .build();

    }

}
