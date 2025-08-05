package za.ac.cput.wisebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.wisebank.domain.Account;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    @Override
    Account save(Account account);

    @Override
    void deleteById(String accountNumber);

    @Override
    Optional<Account> findById(String accountNumber);

    @Override
    List<Account> findAll();
}

