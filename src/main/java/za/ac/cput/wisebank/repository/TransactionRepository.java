package za.ac.cput.wisebank.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.wisebank.domain.Transaction;

import java.util.List;
import java.util.Optional;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Override
    Transaction save(Transaction transaction);

    @Override
    void deleteById(Long TransactionId);

    @Override
    Optional<Transaction> findById(Long TransactionId);

    @Override
    List<Transaction> findAll();

}
//guys check if this page will show up in the final project
//48