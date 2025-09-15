package za.ac.cput.wisebank.factory;

import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Loan;
import za.ac.cput.wisebank.domain.LoanPayment;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.util.Helper;

import java.time.LocalDateTime;
import java.util.List;

public class LoanFactory {
    public static Loan createLoan(Integer loanId, String loanType, String loanStatus, double loanAmount, double loanInterest,
                                  double loanTotal, double monthlyPayment, double outstandingPayment, LocalDateTime loanDate, List<LoanPayment> payments, User user, Account account) {
    if(!Helper.isValidInteger(loanId) ||
        Helper.isNullOrEmpty(loanType) ||
        Helper.isNullOrEmpty(loanStatus) ||
        !Helper.isValidDouble(loanAmount) ||
        !Helper.isValidDouble(loanInterest) ||
        !Helper.isValidDouble(loanTotal) ||
        !Helper.isValidDouble(monthlyPayment) ||
        !Helper.isValidDouble(outstandingPayment)){
        return null;
    }


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
                .setPayments(payments)
                .setUser(user)
                .setAccount(account)
                .build();
    }
}
