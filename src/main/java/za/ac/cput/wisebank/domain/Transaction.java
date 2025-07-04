package za.ac.cput.wisebank.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transactionId;
    private Integer senderAccountId;
    private Integer receiverAccountId;
    private double amount;
    private String status;
    private String description;
    private LocalDate transactionDate;
    private String transactionType;

    protected Transaction() {

    }
    public Transaction(Builder builder) {
        this.transactionId = builder.transactionId;
        this.senderAccountId = builder.senderAccountId;
        this.receiverAccountId = builder.receiverAccountId;
        this.amount = builder.amount;
        this.status = builder.status;
        this.description = builder.description;
        this.transactionDate = builder.transactionDate;
        this.transactionType = builder.transactionType;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public Integer getSenderAccountId() {
        return senderAccountId;
    }

    public Integer getReceiverAccountId() {
        return receiverAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", senderAccountId=" + senderAccountId +
                ", receiverAccountId=" + receiverAccountId +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", transactionDate=" + transactionDate +
                ", Transaction_Type='" + transactionType + '\'' +
                '}';
    }
    public static class Builder {
        private Integer transactionId;
        private Integer senderAccountId;
        private Integer receiverAccountId;
        private double amount;
        private String status;
        private String description;
        private LocalDate transactionDate;
        private String transactionType;

        public Builder setTransactionId(Integer transactionId) {
            this.transactionId = transactionId;
            return this;
        }
        public Builder setSenderAccountId(Integer senderAccountId) {
            this.senderAccountId = senderAccountId;
            return this;
        }
        public Builder setReceiverAccountId(Integer receiverAccountId) {
            this.receiverAccountId = receiverAccountId;
            return this;
        }
        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }
        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Builder setTransactionDate(LocalDate transactionDate) {
            this.transactionDate = transactionDate;
            return this;
        }
        public Builder setTransactionType(String transactionType) {
            this.transactionType = transactionType;
            return this;
        }
        public Transaction build() {
            return new Transaction(this);
        }

    }
}
