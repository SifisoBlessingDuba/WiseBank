package za.ac.cput.wisebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.wisebank.domain.Message;
import za.ac.cput.wisebank.repository.MessageRepository;

import java.util.List;

@Service
public class MessageService implements IMessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message update(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public Message findById(String s) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        messageRepository.deleteById(id);
    }

    @Override
    public Message findById(Integer id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }
}
//guys check if this page will show up in the final project
//70