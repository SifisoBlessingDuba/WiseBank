package za.ac.cput.wisebank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;



import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Card;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.service.CardService;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CardController.class)
public class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CardService cardService;

    @Autowired
    private ObjectMapper objectMapper;

    private Card card;

    @BeforeEach
    void setUp() {
        User user = new User.Builder()
                .setIdNumber("8237927492")
                .setEmail("john.doe@example.com")
                .setPassword("password")
                .setFirstName("John")
                .setLastName("Doe")
                .setPhoneNumber("27123456789L")
                .setAddress("123 Main Street")
                .setCreatedAt(LocalDate.now())
                .setLastLogin(LocalDate.now())
                // For tests, you can skip setting collections or pass null/empty lists if necessary
                .build();

        Account account = new Account.Builder()
                .setAccountNumber("ACC123456")
                .setAccountType("Savings")
                .setAccountBalance(15000.0)
                .setCurrency(1.0) // assuming currency conversion rate or code
                .setBankName("WiseBank")
                .setStatus("Active")
                .setUser(user)
                .build();

        Card card = new Card.Builder()
                .setCardNumber("1234567890123456")
                .setCardType("Debit")
                .setStatus(true)
                .setCardLimit(10000)
                .setCvv(123)
                .setExpiryDate(LocalDate.of(2030, 12, 31))
                .setIssuedDate(LocalDate.of(2023, 1, 1))
                .setAccount(account)
                .setUser(user)
                .build();

        this.card = card;
    }

    @Test
    void testSaveCard() throws Exception {
        when(cardService.save(any(Card.class))).thenReturn(card);

        mockMvc.perform(post("/card/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(card)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cardNumber").value(card.getCardNumber()))
                .andExpect(jsonPath("$.cardType").value("Debit"));

        verify(cardService, times(1)).save(any(Card.class));
    }

    @Test
    void testUpdateCard() throws Exception {
        when(cardService.save(any(Card.class))).thenReturn(card);

        mockMvc.perform(put("/card/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(card)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cardNumber").value("1234567890123456"));

        verify(cardService).save(any(Card.class));
    }

    @Test
    void testDeleteCard() throws Exception {
        doNothing().when(cardService).deleteById("1234567890123456");

        mockMvc.perform(delete("/card/deleteCard1234567890123456"))
                .andExpect(status().isOk());

        verify(cardService).deleteById("1234567890123456");
    }

    @Test
    void testFindById() throws Exception {
        when(cardService.findById("1234567890123456")).thenReturn(card);

        mockMvc.perform(get("/card/rad_card1234567890123456"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cardNumber").value(card.getCardNumber()))
                .andExpect(jsonPath("$.cvv").value(321));

        verify(cardService).findById("1234567890123456");
    }

    @Test
    void testFindAll() throws Exception {
        when(cardService.findAll()).thenReturn(List.of(card));

        mockMvc.perform(get("/card/all_cards"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].cardType").value("Debit"));
    }
}
