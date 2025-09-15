package za.ac.cput.wisebank.domain;


import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Transactional
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private Long transactionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_number", referencedColumnName = "account_number")
    private Account account;

    private BigDecimal amount;
    private String transactionType;
    private LocalDateTime timestamp;
    private String description;
    private String status;

    protected Transaction() {}
    private Transaction(Builder builder) {
        this.transactionId = builder.transactionId;
        this.account = builder.account;
        this.amount = builder.amount;
        this.transactionType = builder.transactionType;
        this.timestamp = builder.timestamp;
        this.description= builder.description;
        this.status = builder.status;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public Account getAccount() {
        return account;
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
                ", account=" + account +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                ", timestamp=" + timestamp +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder {
        private Long transactionId;
        private Account account;
        private BigDecimal amount;
        private String transactionType;
        private LocalDateTime timestamp;
        private String description;
        private String status;

        public Builder setTransactionId(Long transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder setAccount(Account account) {
            this.account = account;
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
        public Builder copy(Transaction transaction) {
            this.transactionId = transaction.transactionId;
            this.account = transaction.account;
            this.amount = transaction.amount;
            this.transactionType = transaction.transactionType;
            this.timestamp = transaction.timestamp;
            this.description = transaction.description;
            this.status = transaction.status;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }


    }
}
