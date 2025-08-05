package za.ac.cput.wisebank.factory;

import za.ac.cput.wisebank.domain.Loan;
import za.ac.cput.wisebank.domain.LoanPayment;

import java.time.LocalDateTime;

public class LoanPaymentFactory {

    public static LoanPayment createLoanPayment(Integer loanId, LocalDateTime paymentDate, Double amountPaid, String status, Loan loan) {

       //oan loan1= new Loan( 123,  "installment", "monthly payment" , 2000.00, 3.5, 15000.00, 2000.00, 7000.00, LocalDateTime.of(2025, 5, 1, 10, 0));
        Loan loan1 = new Loan.Builder()
                .setLoanId(123)
                .setLoanType("installment")
                .setLoanStatus("monthly payment")
                .setLoanAmount(2000.00)
                .setLoanInterest(3.5)
                .setLoanTotal(15000.00)
                .setMonthlyPayment(2000.00)
                .setOutstandingPayment(7000.00)
                .setLoanDate(LocalDateTime.of(2025, 5, 1, 10, 0))
                .build();
        return new LoanPayment.Builder()

                .setLoanId(loanId)
                .setPaymentDate(paymentDate)
                .setAmountPaid(amountPaid)
                .setStatus(status)
                .setLoan(loan1)
                .build();

    }
}
