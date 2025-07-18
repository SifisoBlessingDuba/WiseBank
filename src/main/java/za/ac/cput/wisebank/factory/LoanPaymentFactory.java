package za.ac.cput.wisebank.factory;

import za.ac.cput.wisebank.domain.Loan;
import za.ac.cput.wisebank.domain.LoanPayment;

import java.time.LocalDateTime;

public class LoanPaymentFactory {

    public static LoanPayment createLoanPayment(Integer paymentId, Integer loanId, LocalDateTime paymentDate, Double amountPaid, String status, Loan loan) {

        return new LoanPayment.Builder()
                .setPaymentId(paymentId)
                .setLoanId(loanId)
                .setPaymentDate(paymentDate)
                .setAmountPaid(amountPaid)
                .setStatus(status)
                .setLoan(loan)
                .build();

    }
}
