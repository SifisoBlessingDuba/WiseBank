package za.ac.cput.wisebank.factory;

import za.ac.cput.wisebank.domain.Loan;
import za.ac.cput.wisebank.domain.LoanPayment;

import java.time.LocalDateTime;

public class LoanPaymentFactory {

    public static LoanPayment createLoanPayment(Integer paymentId, Integer loanId, LocalDateTime paymentDate, Double amountPaid, String status, Loan loan) {

        //Loan loan1= new Loan( 123, "monthly", "installment", "monthly payment" , 2000.00, 3.5, 15000.00, 2000.00, 7000.00, LocalDateTime.of(2025, 5, 1, 10, 0));
        //To be fixed...
        return new LoanPayment.Builder()
                .setPaymentId(paymentId)
                .setLoanId(loanId)
                .setPaymentDate(paymentDate)
                .setAmountPaid(amountPaid)
                .setStatus(status)
                //.setLoan(loan1)
                .build();

    }
}
