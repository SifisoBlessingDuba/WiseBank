package za.ac.cput.wisebank.factory;

import za.ac.cput.wisebank.domain.Loan;
import za.ac.cput.wisebank.domain.LoanPayment;

import java.time.LocalDateTime;
import java.util.List;

public class LoanFactory {
    public static Loan createLoan(Integer loanId, String loanType, String loanStatus, double loanAmount, double loanInterest,
                                  double loanTotal, double monthlyPayment, double outstandingPayment, LocalDateTime loanDate, List<LoanPayment> payments){

        return new Loan.Builder()
                .setLoanId(loanId)
                .setLoanType(loanType)
                .setLoanStatus(loanStatus)
                .setLoanAmount(loanAmount)
                .setLoanInterest(loanInterest)
                .setLoanTotal(loanTotal)
                .setMonthlyPayment(monthlyPayment)
                .setOutstandingPayment(outstandingPayment)
                .setLoanDate(loanDate)
                .setLoanPayments(payments)
                .build();
    }
}
