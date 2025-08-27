package za.ac.cput.wisebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.wisebank.domain.LoanPayment;
import za.ac.cput.wisebank.domain.Notification;
import za.ac.cput.wisebank.service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/Notification")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping({"/save"})
    public Notification save(@RequestBody Notification notification) {
        return notificationService.save(notification);
    }

    @PutMapping("/update")
    public Notification update(@RequestBody Notification notification) {
        return notificationService.update(notification);
    }

    @GetMapping("/find_notificaion{id}")
    public Notification findNotification(@PathVariable Integer id) {
        return notificationService.findById(id);
    }

    @DeleteMapping("/delete-notification{id}")
    public void deleteById(@PathVariable Integer id) {
        notificationService.deleteById(id);
    }

    @GetMapping("/all-loans")
    public List<Notification> getAllNotifications() {
        return notificationService.getAll();
    }
}
