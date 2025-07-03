package za.ac.cput.wisebank.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.Transaction;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class TransactionFactoryTest {

    @Test
    void createTransaction() {
        Transaction transaction = TransactionFactory.createTransaction( 22111, 33332, 1000.00, "Pending", "text unit to the database", LocalDate.now(),"general");
        assertNotNull(transaction);
        System.out.println(transaction);
    }
}