package za.ac.cput.wisebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Notification extends JpaRepository<Notification, Integer> {

    @Override
    Notification save (Notification notification);

    @Override
    void deleteById(Integer id);

    @Override
    Optional<Notification> findById(Integer id);

    @Override
    List<Notification> findAll();



}
