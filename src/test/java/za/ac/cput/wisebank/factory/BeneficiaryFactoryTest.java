package za.ac.cput.wisebank.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.Beneficiary;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class BeneficiaryFactoryTest {

    @Test
    void createBeneficiary() {
        Beneficiary beneficiary = BeneficiaryFactory.createBeneficiary(10292, 1923, "109238349", "Mike", "ABSA", LocalDate.now());
        assertNotNull(beneficiary);
        System.out.println(beneficiary);
    }
}