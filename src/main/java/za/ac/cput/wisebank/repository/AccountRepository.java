package za.ac.cput.wisebank.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.wisebank.domain.Account;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Integer> {

    /*@Override
    Account save(Account account);

    @Override
    void deleteById(Integer accountId);

    @Override
    Optional<Account> findById(Integer accountId);

    @Override
    List<Account> findAll();*/
}

