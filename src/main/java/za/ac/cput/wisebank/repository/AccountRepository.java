package za.ac.cput.wisebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.wisebank.domain.Account;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Override
    Account save(Account account);

    @Override
    void deleteById(Integer accountId);

    @Override
    Optional<Account> findById(Integer accountId);

    @Override
    List<Account> findAll();
}

