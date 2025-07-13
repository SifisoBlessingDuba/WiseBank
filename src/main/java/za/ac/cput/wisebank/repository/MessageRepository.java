package za.ac.cput.wisebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.wisebank.domain.Message;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Override
    Message save(Message message);

    @Override
    void deleteById(Integer messageId);

    @Override
    Optional<Message> findById(Integer messageId);

    @Override
    List<Message> findAll();
}

