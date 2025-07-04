package za.ac.cput.wisebank.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class LoanPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    private Integer loanId;
    private Date paymentDate;
    private Double amountPaid;
    private String status;

    protected LoanPayment() {

    }

    private LoanPayment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.loanId = builder.loanId;
        this.paymentDate = builder.paymentDate;
        this.amountPaid = builder.amountPaid;
        this.status = builder.status;
    }
    public Integer getPaymentId() {
        return paymentId;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "LoanPayment{" + "paymentId=" + paymentId
                + ", loanId=" + loanId + '\''
                + ", paymentDate=" + paymentDate + '\''
                + ", amountPaid=" + amountPaid + '\''
                + ", status=" + status + '}';
    }

    public static class Builder {

        private Integer paymentId;
        private Integer loanId;
        private Date paymentDate;
        private Double amountPaid;
        private String status;

        public Builder setPaymentId(Integer paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setLoanId(Integer loanId) {
            this.loanId = loanId;
            return this;
        }

        public Builder setPaymentDate(Date paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setAmountPaid(Double amountPaid) {
            this.amountPaid = amountPaid;
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
