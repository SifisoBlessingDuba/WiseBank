//package za.ac.cput.wisebank.factory;
//
//import org.junit.jupiter.api.Test;
//import za.ac.cput.wisebank.domain.Account;
//import za.ac.cput.wisebank.domain.Transaction;
//import za.ac.cput.wisebank.Factory.TransactionFactory;
//import java.math.BigDecimal;
//import java.time.LocalDateTime;
//
//import static org.junit.jupiter.api.Assertions.*;
//class TransactionFactoryTest {
//
//    @Test
//    void createTransaction() {
//        // Create test data
//        Account testAccount = new Account.Builder()
//                .setAccountNumber("563812723")
//                .setAccountType("SAVINGS")
//                .setAccountBalance(2000.00)
//                .setCurrency(1.0)
//                .setBankName("Test Bank")
//                .setStatus("ACTIVE")
//                .build();
//        BigDecimal amount = new BigDecimal("1000.00");
//        String transactionType = "DEPOSIT";
//        LocalDateTime timestamp = LocalDateTime.now();
//        String description = "Test deposit";
//        String status = "COMPLETED";
//
//        // Create transaction using factory
//        Transaction transaction = TransactionFactory.createTransaction(
//                testAccount,
//                amount,
//                transactionType,
//                timestamp,
//                description,
//                status
//        );
//
//        // Assert that transaction is not null
//        assertNotNull(transaction);
//
//        // Assert that all fields are set correctly
//        assertEquals(transactionId, transaction.getTransactionId());
//        assertNotNull(transaction.getAccount());
//        assertEquals(amount, transaction.getAmount());
//        assertEquals(transactionType, transaction.getTransactionType());
//        assertEquals(timestamp, transaction.getTimestamp());
//        assertEquals(description, transaction.getDescription());
//        assertEquals(status, transaction.getStatus());
//    }
//
//    @Test
//    void testCreateTransaction() {
//        // Create test data
//        Long transactionId = 2L;
//        Account testAccount = new Account.Builder()
//                .setAccountNumber("563812723")
//                .setAccountType("CHECKING")
//                .setAccountBalance(3000.00)
//                .setCurrency(1.0)
//                .setBankName("Test Bank")
//                .setStatus("ACTIVE")
//                .build();
//        BigDecimal amount = new BigDecimal("500.00");
//        String transactionType = "WITHDRAWAL";
//        LocalDateTime timestamp = LocalDateTime.now();
//
//import za.ac.cput.wisebank.domain.Transaction;// Create transaction using factory (overloaded method with fewer parameters)
//        Transaction transaction = TransactionFactory.createTransaction(
//                transactionId,
//                testAccount,
//                amount,
//                transactionType,
//                timestamp
//        );
//
//
//        // Assert that transaction is not null
//        assertNotNull(transaction
//        // Assert that all provided fields are set correctly
//        assertEquals(transactionId, transaction.getTransactionId());
//        assertNotNull(transaction.getAccount());
//        assertEquals(amount, transaction.getAmount());
//        assertEquals(transactionType, transaction.getTransactionType());
//        assertEquals(timestamp, transaction.getTimestamp());
//
//        // The description and status fields should be null since they weren't provided
//        assertNull(transaction.getDescription());
//        assertNull(transaction.getStatus());
//    }
//}