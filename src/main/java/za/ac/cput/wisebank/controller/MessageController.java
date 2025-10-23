package za.ac.cput.wisebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.wisebank.domain.Message;
import za.ac.cput.wisebank.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/save")
    public Message save(@RequestBody Message message) {
        return messageService.save(message);
    }

    @PutMapping("/update")
    public Message update(@RequestBody Message message) {
        return messageService.update(message);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        messageService.deleteById(id);
    }

    @GetMapping("/read/{id}")
    public Message findById(@PathVariable Integer id) {
        return messageService.findById(id);
    }

    @GetMapping("/all")
    public List<Message> findAll() {
        return messageService.findAll();
    }
}
//guys check if this page will show up in the final project
//11