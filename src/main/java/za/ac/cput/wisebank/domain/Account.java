package za.ac.cput.wisebank.domain;


import jakarta.persistence.*;

import java.util.List;

@Entity
 public class Account {
    @Id
    @Column(name = "account_number")
    private String accountNumber;
    private double accountBalance;
    private String accountType;
    private double currency;
    private String bankName;
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
  // @com.fasterxml.jackson.annotation.JsonBackReference
    private User user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "account")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<Loan> loans;

    public Account() {

    }

    public Account (Builder builder){
        this.accountNumber=builder.accountNumber;
        this.accountType=builder.accountType;
        this.accountBalance=builder.accountBalance;
        this.currency=builder.currency;
        this.bankName=builder.bankName;
        this.status=builder.status;
        this.user = builder.user;
        this.transactions =builder.transactions;
        this.loans = builder.loan;

    }

    @com.fasterxml.jackson.annotation.JsonProperty("accountId")
    public String getAccountNumber() {
        return accountNumber;
    }

    // Also expose the same primary key under a generic "id" field for client compatibility
    @com.fasterxml.jackson.annotation.JsonProperty("id")
    public String getId() {
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

    public User getUser() {
        return user;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Loan> getLoan() {
        return loans;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                ", accountType='" + accountType + '\'' +
                ", currency=" + currency +
                ", bankName='" + bankName + '\'' +
                ", status='" + status + '\'' +
                ", userId=" + (user != null ? user.getIdNumber() : null) +
                ", transactionsCount=" + (transactions != null ? transactions.size() : 0) +
                ", loansCount=" + (loans != null ? loans.size() : 0) +
                '}';
    }

    public static class Builder {
        private String accountNumber;
        private String accountType;
        private double accountBalance;
        private double currency;
        private String bankName;
        private String status;
        private User user;
        private List<Transaction> transactions;
        private List<Loan> loan;

        public Builder setAccountNumber(String accountNumber) {
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
        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setTransactions(List<Transaction> transactions) {
            this.transactions = transactions;
            return this;
        }

        public Builder setLoan(List<Loan> loan) {
            this.loan = loan;
            return this;
        }


        public Account build() {
            return new Account(this);
        }
    }}
