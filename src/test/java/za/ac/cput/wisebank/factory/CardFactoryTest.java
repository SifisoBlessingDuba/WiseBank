package za.ac.cput.wisebank.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.Card;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class CardFactoryTest {

    @Test
    void createCard() {
        Card card = CardFactory.createCard( "123456789", "Savings", true, 1000.00,123, LocalDate.now(),LocalDate.now());
        assertNotNull(card);
        System.out.println(card);
    }
}