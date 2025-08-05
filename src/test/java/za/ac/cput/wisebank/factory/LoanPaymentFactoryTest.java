package za.ac.cput.wisebank.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.LoanPayment;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
class LoanPaymentFactoryTest {

    @Test
    void createLoanPayment() {

        LoanPayment loanPayment = LoanPaymentFactory.createLoanPayment(123456,  LocalDateTime.now(), 50000.00, "paid", null);
        assertNotNull(loanPayment);
    }

}