package za.ac.cput.wisebank.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
class TransactionFactoryTest {

    @Test
    void createTransaction() {
        // Create test data
        Long transactionId = 1L;
        Long senderAccountId = 100L;
        BigDecimal amount = new BigDecimal("1000.00");
        String transactionType = "DEPOSIT";
        LocalDateTime timestamp = LocalDateTime.now();
        String description = "Test deposit";
        String status = "COMPLETED";

        // Create transaction using factory
        Transaction transaction = TransactionFactory.createTransaction(
                transactionId, 
                senderAccountId, 
                amount, 
                transactionType, 
                timestamp, 
                description, 
                status
        );

        // Assert that transaction is not null
        assertNotNull(transaction);

        // Assert that all fields are set correctly
        assertEquals(transactionId, transaction.getTransactionId());
        assertEquals(senderAccountId, transaction.getSenderAccountId());
        assertEquals(amount, transaction.getAmount());
        assertEquals(transactionType, transaction.getTransactionType());
        assertEquals(timestamp, transaction.getTimestamp());
        assertEquals(description, transaction.getDescription());
        assertEquals(status, transaction.getStatus());
    }

    @Test
    void testCreateTransaction() {
        // Create test data
        Long transactionId = 2L;
        Long senderAccountId = 200L;
        BigDecimal amount = new BigDecimal("500.00");
        String transactionType = "WITHDRAWAL";
        LocalDateTime timestamp = LocalDateTime.now();

        // Create transaction using factory (overloaded method with fewer parameters)
        Transaction transaction = TransactionFactory.createTransaction(
                transactionId, 
                senderAccountId, 
                amount, 
                transactionType, 
                timestamp
        );

        // Assert that transaction is not null
        assertNotNull(transaction);

        // Assert that all provided fields are set correctly
        assertEquals(transactionId, transaction.getTransactionId());
        assertEquals(senderAccountId, transaction.getSenderAccountId());
        assertEquals(amount, transaction.getAmount());
        assertEquals(transactionType, transaction.getTransactionType());
        assertEquals(timestamp, transaction.getTimestamp());

        // The description and status fields should be null since they weren't provided
        assertNull(transaction.getDescription());
        assertNull(transaction.getStatus());
    }
}
