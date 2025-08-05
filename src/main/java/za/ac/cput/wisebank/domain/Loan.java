package za.ac.cput.wisebank.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer loanId;
    private String loanType;
    private String loanStatus;
    private double loanAmount;
    private double loanInterest;
    private double loanTotal;
    private double monthlyPayment;
    private double outstandingPayment;
    private LocalDateTime loanDate;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Loan_Paymenty_Id")
    private List<LoanPayment> payments;
    @OneToOne
    @JoinColumn(name = "User_Id")
    private User user;

    @OneToOne
    @JoinColumn(name = "Account_Id")
    private Account account;

    protected Loan(){

    }
    public Loan(Builder builder) {
        this.loanId = builder.loanId;
        this.loanType = builder.loanType;
        this.loanStatus = builder.loanStatus;
        this.loanAmount = builder.loanAmount;
        this.loanInterest = builder.loanInterest;
        this.loanTotal = builder.loanTotal;
        this.monthlyPayment = builder.monthlyPayment;
        this.outstandingPayment = builder.outstandingPayment;
        this.loanDate = builder.loanDate;
        this.payments = builder.payments;
        this.user = builder.user;
        this.account = builder.account;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public double getLoanInterest() {
        return loanInterest;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getLoanTotal() {
        return loanTotal;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public double getOutstandingPayment() {
        return outstandingPayment;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public List<LoanPayment> getPayments() {
        return payments;
    }

    public User getUser() {
        return user;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", loanType='" + loanType + '\'' +
                ", loanStatus='" + loanStatus + '\'' +
                ", loanAmount=" + loanAmount +
                ", loanInterest=" + loanInterest +
                ", loanTotal=" + loanTotal +
                ", monthlyPayment=" + monthlyPayment +
                ", outstandingPayment=" + outstandingPayment +
                ", loanDate=" + loanDate +
                ", payments=" + payments +
                ", user=" + user +
                ", account=" + account +
                '}';
    }

    public static class Builder {
        private Integer loanId;
        private String loanType;
        private String loanStatus;
        private double loanAmount;
        private double loanInterest;
        private double loanTotal;
        private double monthlyPayment;
        private double outstandingPayment;
        private LocalDateTime loanDate;
        private List<LoanPayment> payments;
        private User user;
        private Account account;

        public Builder setLoanId(Integer loanId) {
            this.loanId = loanId;
            return this;
        }
        public Builder setLoanType(String loanType) {
            this.loanType = loanType;
            return this;
        }
        public Builder setLoanStatus(String loanStatus) {
            this.loanStatus = loanStatus;
            return this;
        }
        public Builder setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
            return this;
        }
        public Builder setLoanInterest(double loanInterest) {
            this.loanInterest = loanInterest;
            return this;
        }
        public Builder setLoanTotal(double loanTotal) {
            this.loanTotal = loanTotal;
            return this;
        }
        public Builder setMonthlyPayment(double monthlyPayment) {
            this.monthlyPayment = monthlyPayment;
            return this;
        }
        public Builder setOutstandingPayment(double outstandingPayment) {
            this.outstandingPayment = outstandingPayment;
            return this;
        }
        public Builder setLoanDate(LocalDateTime loanDate) {
            this.loanDate = loanDate;
            return this;
        }
        public Builder setPayments(List<LoanPayment> payments) {
            this.payments = payments;
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
        public Loan build() {
            return new Loan(this);
        }
    }

}
