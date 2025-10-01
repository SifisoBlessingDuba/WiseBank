package za.ac.cput.wisebank.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "withdrawals")
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long withdrawalId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column( nullable = false)
    private double amount;

    @Column(name = "withdrawal_date", nullable = false)
    private LocalDateTime withdrawalDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private WithdrawalStatus withdrawalStatus;

    @Column(name = "recipient_phone_number", nullable = false)
    private String recipientPhoneNumber;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Withdrawal() {}
    private Withdrawal(Builder builder) {
        this.withdrawalId = builder.withdrawalId;
        this.user = builder.user;
        this.account = builder.account;
        this.amount = builder.amount;
        this.withdrawalDate = builder.withdrawalDate;
        this.withdrawalStatus = builder.withdrawalStatus;
        this.recipientPhoneNumber = builder.recipientPhoneNumber;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }
    public Long getWithdrawalId() {
        return withdrawalId;
    }
    public User getUser() {
        return user;
    }
    public Account getAccount() {
        return account;
    }
    public double getAmount() {
        return amount;
    }

    public void setWithdrawalId(Long withdrawalId) {
        this.withdrawalId = withdrawalId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setWithdrawalDate(LocalDateTime withdrawalDate) {
        this.withdrawalDate = withdrawalDate;
    }

    public void setWithdrawalStatus(WithdrawalStatus withdrawalStatus) {
        this.withdrawalStatus = withdrawalStatus;
    }

    public void setRecipientPhoneNumber(String recipientPhoneNumber) {
        this.recipientPhoneNumber = recipientPhoneNumber;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getWithdrawalDate() {
        return withdrawalDate;
    }
    public WithdrawalStatus getWithdrawalStatus() {
        return withdrawalStatus;
    }
    public String getRecipientPhoneNumber() {
        return recipientPhoneNumber;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    @Override
    public String toString() {
        return "Withdrawal{" +
                "withdrawalId=" + withdrawalId +
                ", user=" + user +
                ", account=" + account +
                ", amount=" + amount +
                ", withdrawalDate=" + withdrawalDate +
                ", withdrawalStatus=" + withdrawalStatus +
                ", recipientPhoneNumber='" + recipientPhoneNumber + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
    public static class Builder {
        private Long withdrawalId;
        private User user;
        private Account account;
        private double amount;
        private LocalDateTime withdrawalDate;
        private WithdrawalStatus withdrawalStatus;
        private String recipientPhoneNumber;
        private LocalDateTime createdAt = LocalDateTime.now();
        private LocalDateTime updatedAt = LocalDateTime.now();

        public Builder setId(Long withdrawalId) {
            this.withdrawalId = withdrawalId;
            return this;
        }
        public Builder setUser(User user) {
            this.user = user;
            return this;
        }
        public Builder setAccount(Account account) {
            this.account = account;
            return this;
        }
        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }
        public Builder setWithdrawalDate(LocalDateTime withdrawalDate) {
            this.withdrawalDate = withdrawalDate;
            return this;
        }
        public Builder setWithdrawalStatus(WithdrawalStatus withdrawalStatus) {
            this.withdrawalStatus = withdrawalStatus;
            return this;
        }
        public Builder setRecipientPhoneNumber(String recipientPhoneNumber) {
            this.recipientPhoneNumber = recipientPhoneNumber;
            return this;
        }
        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        public Builder setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }
        public Withdrawal build() {
            return new Withdrawal(this);
        }
    }




}
