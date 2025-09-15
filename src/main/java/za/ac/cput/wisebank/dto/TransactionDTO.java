package za.ac.cput.wisebank.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {
    private Long transactionId;
    private String accountNumber;
    private BigDecimal amount;
    private String transactionType;
    private LocalDateTime timestamp;
    private String description;
    private String status;

    public TransactionDTO() {}

    public TransactionDTO(Long transactionId, String accountNumber, BigDecimal amount,
                          String transactionType, LocalDateTime timestamp,
                          String description, String status) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
        this.timestamp = timestamp;
        this.description = description;
        this.status = status;
    }

    public Long getTransactionId() { return transactionId; }
    public void setTransactionId(Long transactionId) { this.transactionId = transactionId; }

    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }

    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
