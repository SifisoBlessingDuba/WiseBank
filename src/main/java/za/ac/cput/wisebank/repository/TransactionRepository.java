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

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.wisebank.domain.Transaction;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Override
    Transaction save(Transaction transaction);

    @Override
    void deleteById(Integer TransactionId);

    @Override
    Optional<Transaction> findById(Integer TransactionId);

    @Override
    List<Transaction> findAll();

}
