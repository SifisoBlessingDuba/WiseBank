package za.ac.cput.wisebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.wisebank.domain.Notification;

import java.util.List;
import java.util.Optional;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
//    @Override
//    Notification save (Notification notification);
//
//    @Override
//    void deleteById(Integer id);
//
//    @Override
//    Optional<Notification> findById(Integer id);
//
//    @Override
//    List<Notification> findAll();
}
//guys check if this page will show up in the final project
//47