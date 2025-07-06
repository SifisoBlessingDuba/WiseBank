package za.ac.cput.wisebank.Factory;

import za.ac.cput.wisebank.domain.LoanPayment;
import za.ac.cput.wisebank.util.Helper;

import java.time.LocalDateTime;
import java.util.Date;

public class LoanPaymentFactory {

    public static LoanPayment createLoanPayment(Integer paymentId, Integer loanId, LocalDateTime paymentDate, Double amountPaid, String status) {

        return new LoanPayment.Builder()
                .setPaymentId(paymentId)
                .setLoanId(loanId)
                .setPaymentDate(paymentDate)
                .setAmountPaid(amountPaid)
                .setStatus(status)
                .build();

    }
}
