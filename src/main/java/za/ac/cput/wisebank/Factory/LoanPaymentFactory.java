package za.ac.cput.wisebank.factory;

import za.ac.cput.wisebank.domain.LoanPayment;
import za.ac.cput.wisebank.util.Helper;

import java.util.Date;

public class LoanPaymentFactory {

    public static LoanPayment createLoanPayment(Integer paymentId, Integer loanId, Date paymentDate, Double amountPaid, String status) {

        return new LoanPayment.Builder()
                .setPaymentId(paymentId)
                .setLoanId(loanId)
                .setPaymentDate(paymentDate)
                .setAmountPaid(amountPaid)
                .setStatus(status)
                .build();

    }
}
