package za.ac.cput.wisebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.wisebank.domain.Notification;
import za.ac.cput.wisebank.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping({"/save"})
    public Notification save(@RequestBody Notification notification) {
        return notificationService.save(notification);
    }

    @PostMapping("/update")
    public Notification update(@RequestBody Notification notification) {
        return notificationService.update(notification);
    }

    @GetMapping("/findById/{id}")
    public Notification findById(@PathVariable Integer id) {
        return notificationService.findById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Integer id) {
        notificationService.deleteById(id);
    }

    @GetMapping("/find-all")
    public List<Notification> findAll() {
        return notificationService.getAll();
    }
}
