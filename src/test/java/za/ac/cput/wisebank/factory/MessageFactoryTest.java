package za.ac.cput.wisebank.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.Message;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MessageFactoryTest {

    @Test
    void createMessage() {
        Message message = MessageFactory.createMessage(282948, 378837,984497, "Hi this is a test messasge", LocalDateTime.now(), "sent");
        assertNotNull(message);
        System.out.println(message);
    }
}