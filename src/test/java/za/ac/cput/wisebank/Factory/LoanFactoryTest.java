package za.ac.cput.wisebank.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.Loan;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LoanFactoryTest {

    @Test
    void createLoan() {
        Loan loan = LoanFactory.createLoan(12637, "Fixed", "payed", 50000.00,5.2, 30000.00, 5000.00, 35000.00, LocalDateTime.now());
        assertNotNull(loan);
        System.out.println(loan);
    }
}