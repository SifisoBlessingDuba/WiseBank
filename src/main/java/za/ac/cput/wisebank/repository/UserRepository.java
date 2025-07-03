package za.ac.cput.wisebank.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {}
   /* @Override
    Account save(User user);

    @Override
    void deleteById(Integer userId);

    @Override
    Optional<User> findById(Integer userId);

    @Override
    List<User> findAll();
}
*/
