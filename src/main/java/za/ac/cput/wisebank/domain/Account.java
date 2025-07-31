package za.ac.cput.wisebank.domain;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    private long accountNumber;
    private String accountType;
    private double accountBalance;
    private double currency;
    private String bankName;
    private String status;

    public Account() {

    }

    private Account(int accountId, long accountNumber, String accountType, double accountBalance, double currency, String bankName, String status) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
        this.currency = currency;
        this.bankName = bankName;
        this.status = status;
    }
    private Account (Builder builder){
        this.accountId=builder.accountId;
        this.accountNumber=builder.accountNumber;
        this.accountType=builder.accountType;
        this.accountBalance=builder.accountBalance;
        this.currency=builder.currency;
        this.bankName=builder.bankName;
        this.status=builder.status;

    }

    public int getAccountId() {
        return accountId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double getCurrency() {
        return currency;
    }

    public String getBankName() {
        return bankName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountNumber=" + accountNumber +
                ", accountType='" + accountType + '\'' +
                ", accountBalance=" + accountBalance +
                ", currency=" + currency +
                ", bankName='" + bankName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder {
        private int accountId;
        private long accountNumber;
        private String accountType;
        private double accountBalance;
        private double currency;
        private String bankName;
        private String status;

        public Builder setAccountId(int accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder setAccountNumber(long accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setAccountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder setAccountBalance(double accountBalance) {
            this.accountBalance = accountBalance;
            return this;
        }

        public Builder setCurrency(double currency) {
            this.currency = currency;
            return this;
        }

        public Builder setBankName(String bankName) {
            this.bankName = bankName;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }
        public Account build() {
            return new Account(this);
        }
    }

    @OneToMany(mappedBy = "senderAccount")
    private Collection<Transaction> transaction;

    public Collection<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(Collection<Transaction> transaction) {
        this.transaction = transaction;
    }
}
