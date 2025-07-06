package za.ac.cput.wisebank.factory;

import org.springframework.stereotype.Component;
import za.ac.cput.wisebank.domain.Beneficiary;

import java.time.LocalDate;

@Component
public class BeneficiaryFactory {

    public Beneficiary createBeneficiary(
            int beneficiaryId,
            int userId,
            String accountNumber,
            String name,
            String bankName
    ) {
        return new Beneficiary(
                beneficiaryId,
                userId,
                accountNumber,
                name,
                bankName,
                LocalDate.now()
        );
    }
}

