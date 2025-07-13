package za.ac.cput.wisebank.factory;

import org.springframework.stereotype.Component;
import za.ac.cput.wisebank.domain.Beneficiary;

import java.time.LocalDate;

@Component
public class BeneficiaryFactory {
    public static Beneficiary createBeneficiary(Integer beneficiaryId, int userId, String accountNumber, String name, String bankName, LocalDate addedAt) {
        return new Beneficiary.Builder()
                .setBeneficiaryId(beneficiaryId)
                .setUserId(userId)
                .setAccountNumber(accountNumber)
                .setName(name)
                .setBankName(bankName)
                .setAddedAt(addedAt)
                .build();

    }
}

