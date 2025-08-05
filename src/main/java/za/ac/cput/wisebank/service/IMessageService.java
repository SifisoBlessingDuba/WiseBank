package za.ac.cput.wisebank.service;

import za.ac.cput.wisebank.domain.Message;

import java.util.List;

public interface IMessageService extends IService<Message, String> {
    Message save(Message message);
    Message update(Message message);
    void deleteById(Integer id);
    Message findById(Integer id);
    List<Message> findAll();
}
