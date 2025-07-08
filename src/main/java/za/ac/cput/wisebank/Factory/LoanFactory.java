package za.ac.cput.wisebank.Factory;

import za.ac.cput.wisebank.domain.Loan;

import java.time.LocalDateTime;

public class LoanFactory {
    public static Loan createLoan(Integer loanId, String loanType, String loanStatus, double loanAmount, double loanInterest,
                                  double loanTotal, double monthlyPayment, double outstandingPayment, LocalDateTime loanDate){

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
                .build();
    }
}
