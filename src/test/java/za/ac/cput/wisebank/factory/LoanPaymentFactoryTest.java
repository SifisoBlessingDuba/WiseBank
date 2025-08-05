package za.ac.cput.wisebank.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.Loan;
import za.ac.cput.wisebank.domain.LoanPayment;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
class LoanPaymentFactoryTest {

    @Test
    void createLoanPayment() {

        //LoanPayment loanPayment = LoanPaymentFactory.createLoanPayment(123456, LocalDateTime.now(), 50000.00, "paid");
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

        LoanPayment loanPayment = LoanPaymentFactory.createLoanPayment(
                456, // loanId
                LocalDateTime.of(2025, 8, 5, 14, 0), // paymentDate
                2000.00, // amountPaid
                "Completed", // status
                loan1//
        );

        assertNotNull(loanPayment);
        System.out.println();
    }

}