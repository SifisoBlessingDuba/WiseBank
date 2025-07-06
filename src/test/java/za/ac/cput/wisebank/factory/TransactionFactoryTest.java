package za.ac.cput.wisebank.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TransactionFactoryTest {

    @Test
    void createTransaction() {
        Long transactionId = 1L;
        Long senderAccountId = 123456789L;
        BigDecimal amount = new BigDecimal("1000.00");
        String transactionType = "CREDIT";
        LocalDateTime timestamp = LocalDateTime.now();
        String description = "Payment for services";
        String status = "PENDING";

        Transaction transaction = TransactionFactory.createTransaction(
                transactionId, senderAccountId, amount, transactionType, timestamp, description, status);

        assertThat(transaction).isNotNull();
        assertThat(transaction.getTransactionId()).isEqualTo(transactionId);
        assertThat(transaction.getSenderAccountId()).isEqualTo(senderAccountId);
        assertThat(transaction.getAmount()).isEqualByComparingTo(amount);
        assertThat(transaction.getTransactionType()).isEqualTo(transactionType);
        assertThat(transaction.getTimestamp()).isEqualTo(timestamp);
        assertThat(transaction.getDescription()).isEqualTo(description);
        assertThat(transaction.getStatus()).isEqualTo(status);

    }

    @Test
    void testCreateTransaction() {
        Long transactionId = 2L;
        Long senderAccountId = 200L;
        BigDecimal amount = BigDecimal.valueOf(500);
        String type = "DEBIT";
        LocalDateTime timestamp = LocalDateTime.now();

        Transaction tx = TransactionFactory.createTransaction(
                transactionId, senderAccountId, amount, type, timestamp);

        assertThat(tx).isNotNull();
        assertThat(tx.getTransactionId()).isEqualTo(transactionId);
        assertThat(tx.getSenderAccountId()).isEqualTo(senderAccountId);
        assertThat(tx.getAmount()).isEqualByComparingTo(amount);
        assertThat(tx.getTransactionType()).isEqualTo(type);
        assertThat(tx.getTimestamp()).isEqualTo(timestamp);

        // Optional fields should be null
        assertThat(tx.getDescription()).isNull();
        assertThat(tx.getStatus()).isNull();
    }

    @Test
    void updateTransaction() {
        Transaction original = new Transaction.Builder()
                .setTransactionId(10L)
                .setSenderAccountId(100L)
                .setAmount(BigDecimal.valueOf(300))
                .setTransactionType("CREDIT")
                .setTimestamp(LocalDateTime.of(2024, 1, 1, 10, 0))
                .setDescription("Initial")
                .setStatus("PENDING")
                .build();

        Transaction updates = new Transaction.Builder()
                .setAmount(BigDecimal.valueOf(500))
                .setStatus("COMPLETED")
                .build();

        TransactionFactory factory = new TransactionFactory();
        Transaction result = factory.updateTransaction(original, updates);

        assertThat(result.getTransactionId()).isEqualTo(original.getTransactionId());
        assertThat(result.getSenderAccountId()).isEqualTo(original.getSenderAccountId());
        assertThat(result.getAmount()).isEqualByComparingTo(BigDecimal.valueOf(500));
        assertThat(result.getTransactionType()).isEqualTo("CREDIT");
        assertThat(result.getTimestamp()).isEqualTo(original.getTimestamp());
        assertThat(result.getDescription()).isEqualTo("Initial");
        assertThat(result.getStatus()).isEqualTo("COMPLETED");
    }
}