package za.ac.cput.wisebank.dto;

import za.ac.cput.wisebank.domain.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionRequest {
    private Long transactionId;
    private Long senderAccountId;
    private BigDecimal amount;
    private String transactionType;
    private LocalDateTime timestamp;
    private String description;
    private String status;

    public TransactionRequest() {}

    public TransactionRequest(Long transactionId,Long senderAccountId,BigDecimal amount, String transactionType,
                              LocalDateTime timestamp, String description, String status) {
        this.transactionId = transactionId;
        this.senderAccountId = senderAccountId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.timestamp = timestamp;
        this.description = description;
        this.status = status;
    }
    public Long getTransactionId() {
        return transactionId;
    }

    public Long getSenderAccountId() {
        return senderAccountId;
    }
    public BigDecimal getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getDescription() {
        return description;
    }
    public String getStatus() {
        return status;
    }
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
    public void setSenderAccountId(Long senderAccountId) {
        this.senderAccountId = senderAccountId;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Transaction toTransaction() {
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
}
