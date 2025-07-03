package za.ac.cput.wisebank.Factory;

import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.util.Helper;

public class AccountFactory {
    public static Account createAccount( Integer accountId,
                                         Long accountNumber,
                                         String accountType,
                                         double accountBalance ,
                                         double currency ,
                                         String status) {
        if (
                !Helper.isValidLong(accountNumber) ||
                        Helper.isNullOrEmpty(accountType) ||
                        !Helper.isValidDouble(accountBalance) ||
                        !Helper.isValidDouble(currency) ||
                        Helper.isNullOrEmpty(status)
        ) {
            return null;
        }
        return new Account.Builder()
                .setAccountId(accountId)
                .setAccountNumber(accountNumber)
                .setAccountType(accountType)
                .setAccountBalance(accountBalance)
                .setCurrency(currency)
                .setStatus(status)
                .build();

    }
}
