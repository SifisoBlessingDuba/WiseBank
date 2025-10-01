package za.ac.cput.wisebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.wisebank.domain.Message;
import za.ac.cput.wisebank.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public Message update(Message message) {
        return messageRepository.save(message); // same as save
    }

    public void deleteById(Integer id) {
        messageRepository.deleteById(id);
    }

    public Message findById(Integer id) {
        return messageRepository.findById(id).orElse(null);
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    public List<Message> findByUserId(String userId) {
        return messageRepository.findByUser_UserId(userId);
    }
}
