package za.ac.cput.wisebank.factory;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Component;
import za.ac.cput.wisebank.domain.*;
import za.ac.cput.wisebank.util.Helper;

import java.util.List;

@Component
public class AccountFactory {
    public static Account createAccount(String accountNumber, String accountType, double accountBalance , double currency , String status , User user,
                                        List<Transaction> transactions, List<Loan> loans) {
        if (Helper.isNullOrEmpty(accountNumber) ||
                        Helper.isNullOrEmpty(accountType) ||
                        !Helper.isValidDouble(accountBalance) ||
                        !Helper.isValidDouble(currency) ||
                        Helper.isNullOrEmpty(status)
        ) {
            return null;
        }
        return new Account.Builder()
                .setAccountNumber(accountNumber)
                .setAccountType(accountType)
                .setAccountBalance(accountBalance)
                .setCurrency(currency)
                .setStatus(status)
                .setUser(user)
                .setTransactions(transactions)
                .setLoan(loans)
                .build();

    }
}
//guys check if this page will show up in the final project
//33