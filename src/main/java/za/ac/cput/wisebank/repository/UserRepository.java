package za.ac.cput.wisebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.wisebank.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Override
    User save(User user);

    @Override
    void deleteById(String userId);

    @Override
    Optional<User> findById(String userId);

    @Override
    List<User> findAll();

    // lookup by email for authentication
    Optional<User> findByEmail(String email);
}
