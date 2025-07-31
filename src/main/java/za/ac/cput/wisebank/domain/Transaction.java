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
    private Integer transactionId;
    @ManyToOne
    @JoinColumn(name = "sender_account")
    private Account senderAccount;
    private BigDecimal amount;
    private String transactionType;
    private LocalDateTime timestamp;
    private String description;
    private String status;



    protected Transaction() {}
    private Transaction(Builder builder) {
        this.transactionId = builder.transactionId;
        this.senderAccount = builder.senderAccount;
        this.amount = builder.amount;
        this.transactionType = builder.transactionType;
        this.timestamp = builder.timestamp;
        this.description= builder.description;
        this.status = builder.status;
        this.transactionType= builder.transactionType;

    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public Account getSenderAccount() {
        return senderAccount;
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
                ", senderAccountId=" + senderAccount +
                ", amount=" + amount +
                ", transactionType='" + transactionType + '\'' +
                ", Date=" + timestamp +
                ", Description='" + description + '\'' +
                ", Status" + status + '\'' +
                '}';
    }

    public static class Builder {
        private int transactionId;
        private Account senderAccount;
        private BigDecimal amount;
        private String transactionType;
        private LocalDateTime timestamp;
        private String description;
        private String status;

        public Builder setTransactionId(int transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder setSenderAccount(Account senderAccount) {
            this.senderAccount = senderAccount;
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
            this.timestamp = timestamp.now();
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
