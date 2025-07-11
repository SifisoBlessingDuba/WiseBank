package za.ac.cput.wisebank.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Transactional
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    private Long senderAccountId;
    private BigDecimal amount;
    private String transactionType;
    private LocalDateTime timestamp;
    private String description;
    private String status;

    protected Transaction() {}
    private Transaction(Builder builder) {
        this.transactionId = builder.transactionId;
        this.senderAccountId = builder.senderAccountId;
        this.amount = builder.amount;
        this.transactionType = builder.transactionType;
        this.timestamp = builder.timestamp;
        this.description= builder.description;
        this.status = builder.status;
        this.transactionType= builder.transactionType;

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

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", senderAccountId=" + senderAccountId +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                ", timestamp=" + timestamp +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder {
        private Long transactionId;
        private Long senderAccountId;
        private BigDecimal amount;
        private String transactionType;
        private LocalDateTime timestamp;
        private String description;
        private String status;

        public Builder setTransactionId(Long transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder setSenderAccountId(Long senderAccountId) {
            this.senderAccountId = senderAccountId;
            return this;
        }

        public Builder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder setTransactionType(String transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Builder setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }
        public Transaction build() {
            return new Transaction(this);
        }


    }
}
