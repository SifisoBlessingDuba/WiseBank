package za.ac.cput.wisebank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import za.ac.cput.wisebank.domain.Message;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.repository.MessageRepository;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageService messageService;

    private Message testMessage;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        User user = new User.Builder()
                .setUserid(1)
                .build();

        testMessage = new Message.Builder()
                .setMessageId(1)
                .setUser(user)
                .setContent("Hello World")
                .setTimestamp(LocalDateTime.now())
                .setStatus("sent")
                .build();
    }

    @Test
    void testFindAll() {
        List<Message> messages = List.of(testMessage);
        when(messageRepository.findAll()).thenReturn(messages);

        List<Message> result = messageService.findAll();

        assertEquals(1, result.size());
        assertEquals("Hello World", result.get(0).getContent());
        verify(messageRepository).findAll();
    }

    @Test
    void testSaveMessage() {
        when(messageRepository.save(testMessage)).thenReturn(testMessage);

        Message saved = messageService.save(testMessage);

        assertNotNull(saved);
        assertEquals("sent", saved.getStatus());
        verify(messageRepository).save(testMessage);
    }

    @Test
    void testUpdateMessage() {
        when(messageRepository.save(testMessage)).thenReturn(testMessage);

        Message updated = messageService.update(testMessage);

        assertEquals("Hello World", updated.getContent());
        verify(messageRepository).save(testMessage);
    }

    @Test
    void testDeleteMessage() {
        Integer messageId = 1;
        doNothing().when(messageRepository).deleteById(messageId);

        messageService.deleteById(messageId);

        verify(messageRepository).deleteById(messageId);
    }

    @Test
    void testFindMessageByIdExists() {
        when(messageRepository.findById(1)).thenReturn(Optional.of(testMessage));

        Message found = messageService.findById(1);

        assertNotNull(found);
        assertEquals(1, found.getUser().getUserid());
        verify(messageRepository).findById(1);
    }

    @Test
    void testFindMessageByIdNotExists() {
        when(messageRepository.findById(2)).thenReturn(Optional.empty());

        Message found = messageService.findById(2);

        assertNull(found);
        verify(messageRepository).findById(2);
    }
}

