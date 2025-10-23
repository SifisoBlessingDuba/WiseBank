package za.ac.cput.wisebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.wisebank.domain.Notification;
import za.ac.cput.wisebank.repository.NotificationRepository;

import java.util.List;

@Service
public class NotificationService implements INotificationService {
@Autowired
    private NotificationRepository notificationRepository;

//    @Autowired
//    public NotificationService(NotificationRepository notificationRepository){
//
//        this.notificationRepository = notificationRepository;
//    }

    @Override
    public Notification save(Notification notification){

        return notificationRepository.save(notification);
    }

    @Override
    public Notification update(Notification notification){

        return notificationRepository.save(notification);
    }

    @Override
    public Notification findById(Integer id){

        return notificationRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id){

        notificationRepository.deleteById(id);

    }

    @Override
    public List<Notification> getAll(){

        return notificationRepository.findAll();
    }

}
//guys check if this page will show up in the final project
//71
