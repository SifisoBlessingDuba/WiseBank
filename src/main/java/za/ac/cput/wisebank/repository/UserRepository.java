package za.ac.cput.wisebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.wisebank.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    User save(User user);

    @Override
    void deleteById(Integer userId);

    @Override
    Optional<User> findById(Integer userId);

    @Override
    List<User> findAll();
}

