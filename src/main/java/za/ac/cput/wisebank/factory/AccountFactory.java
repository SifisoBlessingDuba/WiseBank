package za.ac.cput.wisebank.factory;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Component;
import za.ac.cput.wisebank.domain.*;
import za.ac.cput.wisebank.util.Helper;

import java.util.List;

@Component
public class AccountFactory {
    public static Account createAccount(Integer accountId,
                                        Long accountNumber,
                                        String accountType,
                                        double accountBalance ,
                                        double currency ,
                                        String status ,
                                        User user,
                                        Card card,
                                        List<Transaction> transactions,
                                        List<LoanPayment> loans) {
        /*if (
                !Helper.isValidLong(accountNumber) ||
                        Helper.isNullOrEmpty(accountType) ||
                        !Helper.isValidDouble(accountBalance) ||
                        !Helper.isValidDouble(currency) ||
                        Helper.isNullOrEmpty(status)
        ) {
            return null;
        }*/
        return new Account.Builder()
                .setAccountId(accountId)
                .setAccountNumber(accountNumber)
                .setAccountType(accountType)
                .setAccountBalance(accountBalance)
                .setCurrency(currency)
                .setStatus(status)
                .setUser(user)
                .setCard(card)
                .setTransactions(transactions)
                .setLoans(loans)
                .build();

    }
}
