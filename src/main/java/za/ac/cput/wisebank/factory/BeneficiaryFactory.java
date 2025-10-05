package za.ac.cput.wisebank.factory;

import org.springframework.stereotype.Component;
import za.ac.cput.wisebank.domain.Beneficiary;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.util.Helper;

import java.time.LocalDate;

@Component
public class BeneficiaryFactory {

    public static Beneficiary createBeneficiary(User user, String accountNumber, String name, String bankName, LocalDate date) {
        if(Helper.isNullOrEmpty(accountNumber) ||
            Helper.isNullOrEmpty(name) ||
            Helper.isNullOrEmpty(bankName)){
            return null;
        }
        return new Beneficiary.Builder()
                .setUser(user)
                .setAccountNumber(accountNumber)
                .setName(name)
                .setBankName(bankName)
                .setAddedAt(date)
                .build();
    }
}
