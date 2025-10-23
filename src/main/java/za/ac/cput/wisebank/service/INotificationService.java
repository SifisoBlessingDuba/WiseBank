package za.ac.cput.wisebank.service;

import za.ac.cput.wisebank.domain.Notification;

import java.util.List;

public interface INotificationService extends IService<Notification, Integer>{

    List<Notification> getAll();

}
//guys check if this page will show up in the final project
//64