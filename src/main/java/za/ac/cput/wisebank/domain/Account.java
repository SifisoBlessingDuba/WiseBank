package za.ac.cput.wisebank.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Transaction> transactions = new ArrayList<>();

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
        if (builder.transactions != null) {
            this.transactions = builder.transactions;
        }
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
    
    public List<Transaction> getTransactions() {
        return transactions;
    }
    
    // Helper method to add a transaction to this account
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    
    // Helper method to remove a transaction from this account
    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
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
                ", transactions=" + (transactions != null ? transactions.size() : 0) + " items" +
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
        private List<Transaction> transactions;

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
        
        public Builder setTransactions(List<Transaction> transactions) {
            this.transactions = transactions;
            return this;
        }
        
        public Account build() {
            return new Account(this);
        }
    }
}
