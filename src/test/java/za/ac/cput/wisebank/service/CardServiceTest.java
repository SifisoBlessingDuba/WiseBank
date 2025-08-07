package za.ac.cput.wisebank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Card;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.repository.CardRepository;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CardServiceTest {

    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private CardService cardService;

    private Card testCard;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        User user = new User();
        Account account = new Account();

        testCard = new Card.Builder()
                .setCardNumber("1234567890123456")
                .setCardType("Visa")
                .setStatus(true)
                .setCardLimit(10000)
                .setCvv(123)
                .setIssuedDate(LocalDate.of(2022, 1, 1))
                .setExpiryDate(LocalDate.of(2025, 1, 1))
                .setAccount(account)
                .setUser(user)
                .build();
    }

    @Test
    void testFindAll() {
        List<Card> cardList = List.of(testCard);
        when(cardRepository.findAll()).thenReturn(cardList);

        List<Card> result = cardService.findAll();

        assertEquals(1, result.size());
        assertEquals("Visa", result.get(0).getCardType());
        verify(cardRepository).findAll();
    }

    @Test
    void testSaveCard() {
        when(cardRepository.save(testCard)).thenReturn(testCard);

        Card saved = cardService.save(testCard);

        assertNotNull(saved);
        assertEquals(123, saved.getCvv());
        verify(cardRepository).save(testCard);
    }

    @Test
    void testUpdateCard() {
        when(cardRepository.save(testCard)).thenReturn(testCard);

        Card updated = cardService.update(testCard);

        assertEquals(10000, updated.getCardLimit());
        verify(cardRepository).save(testCard);
    }

    @Test
    void testDeleteCard() {
        String cardNumber = "1234567890123456";
        doNothing().when(cardRepository).deleteById(cardNumber);

        cardService.deleteById(cardNumber);

        verify(cardRepository).deleteById(cardNumber);
    }

    @Test
    void testFindCardByIdExists() {
        when(cardRepository.findById("1234567890123456")).thenReturn(Optional.of(testCard));

        Card found = cardService.findById("1234567890123456");

        assertNotNull(found);
        assertEquals("Visa", found.getCardType());
        verify(cardRepository).findById("1234567890123456");
    }

    @Test
    void testFindCardByIdNotExists() {
        when(cardRepository.findById("0000000000000000")).thenReturn(Optional.empty());

        Card found = cardService.findById("0000000000000000");

        assertNull(found);
        verify(cardRepository).findById("0000000000000000");
    }
}
