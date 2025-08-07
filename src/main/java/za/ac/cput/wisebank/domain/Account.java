package za.ac.cput.wisebank.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "account")
    private List<Loan> loans;

    @OneToOne(mappedBy = "account")
    private Card card;

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
        this.card = builder.card;
        this.transactions =builder.transactions;
        this.loans = builder.loan;

    }

    public String getAccountNumber() {
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

    public Card getCard() {
        return card;
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
                ", accountNumber=" + accountNumber +
                ", accountBalance=" + accountBalance +
                ", accountType='" + accountType + '\'' +
                ", currency=" + currency +
                ", bankName='" + bankName + '\'' +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", card=" + card+
                ", transactions=" + transactions +
                ", loan=" + loans +
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
        private Card card;
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

        public Builder setCard(Card card) {
            this.card = card;
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

