package za.ac.cput.wisebank.domain;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import jakarta.persistence.*;

import java.util.List;

@Entity
 public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;
    private long accountNumber;

    private double accountBalance;
    private String accountType;
    private double currency;
    private String bankName;
    private String status;

   @OneToOne(mappedBy = "account")
   private User user;

    @OneToOne(mappedBy = "linkedAccount")
    private Card card;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "account")
    private List<LoanPayment> loanpayement;

    protected Account() {

    }

    public Account(int accountId, long accountNumber, double accountBalance, String accountType, double currency, String bankName, String status, User user, Card card, List<Transaction> transactions, List<LoanPayment> loanpayement) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountType = accountType;
        this.currency = currency;
        this.bankName = bankName;
        this.status = status;
        this.user = user;
        this.card = card;
        this.transactions = transactions;
        this.loanpayement = loanpayement;
    }

    public Account (Builder builder){
        this.accountId=builder.accountId;
        this.accountNumber=builder.accountNumber;
        this.accountType=builder.accountType;
        this.accountBalance=builder.accountBalance;
        this.currency=builder.currency;
        this.bankName=builder.bankName;
        this.status=builder.status;
        this.user = builder.user;
        this.card = builder.card;
        this.transactions =builder.transactions;
        this.loanpayement = builder.loanpayement;

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
                ", accountBalance=" + accountBalance +
                ", accountType='" + accountType + '\'' +
                ", currency=" + currency +
                ", bankName='" + bankName + '\'' +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", card=" + card +
                ", transactions=" + transactions +
                ", loanpayement=" + loanpayement +
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
        private User user;
        private Card card;
        private List<Transaction> transactions;
        private List<LoanPayment> loanpayement;


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

        public Builder setLoans(List<LoanPayment> loanpayment) {
            this.loanpayement = loanpayment;
            return this;
        }


        public Account build() {
            return new Account(this);
        }
    }}

