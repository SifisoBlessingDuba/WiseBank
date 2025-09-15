package za.ac.cput.wisebank.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Transaction;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class TransactionFactoryTest {

    @Test
    void createTransaction_withAllFields() {
        Account testAccount = new Account.Builder()
                .setAccountNumber("563812723")
                .build();
        Long transactionId = 1L;
        BigDecimal amount = new BigDecimal("1000.00");
        String transactionType = "DEPOSIT";
        LocalDateTime timestamp = LocalDateTime.now();
        String description = "Test deposit";
        String status = "COMPLETED";

        Transaction transaction = TransactionFactory.createTransaction(
                transactionId,
                testAccount,
                amount,
                transactionType,
                timestamp,
                description,
                status
        );

        assertNotNull(transaction);
        assertEquals(transactionId, transaction.getTransactionId());
        assertEquals(testAccount.getAccountNumber(), transaction.getAccount().getAccountNumber());
        assertEquals(amount, transaction.getAmount());
        assertEquals(transactionType, transaction.getTransactionType());
        assertEquals(timestamp, transaction.getTimestamp());
        assertEquals(description, transaction.getDescription());
        assertEquals(status, transaction.getStatus());
    }

    @Test
    void createTransaction_minimal() {
        Long transactionId = 2L;
        Account testAccount = new Account.Builder()
                .setAccountNumber("563812723")
                .build();
        BigDecimal amount = new BigDecimal("500.00");
        String transactionType = "WITHDRAWAL";
        LocalDateTime timestamp = LocalDateTime.now();

        Transaction transaction = TransactionFactory.createTransaction(
                transactionId,
                testAccount,
                amount,
                transactionType,
                timestamp
        );

        assertNotNull(transaction);
        assertEquals(transactionId, transaction.getTransactionId());
        assertEquals(testAccount.getAccountNumber(), transaction.getAccount().getAccountNumber());
        assertEquals(amount, transaction.getAmount());
        assertEquals(transactionType, transaction.getTransactionType());
        assertEquals(timestamp, transaction.getTimestamp());
        assertNull(transaction.getDescription());
        assertNull(transaction.getStatus());
    }
}