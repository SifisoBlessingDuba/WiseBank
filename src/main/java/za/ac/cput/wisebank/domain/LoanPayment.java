package za.ac.cput.wisebank.domain;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
public class LoanPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private Integer loanId;
    private LocalDateTime paymentDate;
    private Double amountPaid;
    private String status;


    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    protected LoanPayment() {

    }

    public void setLoan(Loan loan){
        this.loan = loan;
    }

    public LoanPayment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.loanId = builder.loanId;
        this.paymentDate = builder.paymentDate;
        this.amountPaid = builder.amountPaid;
        this.status = builder.status;
        this.loan = builder.loan;
    }
    public Integer getPaymentId() {
        return paymentId;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public String getStatus() {
        return status;
    }

    public Loan getLoan() {
        return loan;

    }

    @Override
    public String toString() {
        return "LoanPayment{" + "paymentId=" + paymentId
                + ", loanId=" + loanId + '\''
                + ", paymentDate=" + paymentDate + '\''
                + ", amountPaid=" + amountPaid + '\''
                + ", status=" + status +  '\''
                + "loan=" + loan +'}';
    }

    public static class Builder {

        private Integer paymentId;
        private Integer loanId;
        private LocalDateTime paymentDate;
        private Double amountPaid;
        private String status;
        private Loan loan;

        public Builder setPaymentId(Integer paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setLoanId(Integer loanId) {
            this.loanId = loanId;
            return this;
        }

        public Builder setPaymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setAmountPaid(Double amountPaid) {
            this.amountPaid = amountPaid;
            return this;
        }

        public Builder setLoan(Loan loan){
            this.loan = loan;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public LoanPayment build() {
            return new LoanPayment(this);
        }
    }

}
