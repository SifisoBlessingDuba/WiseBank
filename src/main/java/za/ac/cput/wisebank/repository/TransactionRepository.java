package za.ac.cput.wisebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.wisebank.domain.Transaction;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findBySenderAccountId(Long senderAccountId);
    List<Transaction> findByTransactionType(String transactionType);
    List<Transaction> findByStatus(String status);
    List<Transaction> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

    Transaction getTransactionById(Long transactionId);
}
