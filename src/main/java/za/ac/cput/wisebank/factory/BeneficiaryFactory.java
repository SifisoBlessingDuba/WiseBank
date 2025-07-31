package za.ac.cput.wisebank.factory;

import org.springframework.stereotype.Component;
import za.ac.cput.wisebank.domain.Beneficiary;
import za.ac.cput.wisebank.domain.User;

import java.time.LocalDate;

@Component
public class BeneficiaryFactory {

    public Beneficiary createBeneficiary(
            User user,
            String accountNumber,
            String name,
            String bankName
    ) {
        return new Beneficiary.Builder()
                .setUser(user)
                .setAccountNumber(accountNumber)
                .setName(name)
                .setBankName(bankName)
                .setAddedAt(LocalDate.now())
                .build();
    }
}
