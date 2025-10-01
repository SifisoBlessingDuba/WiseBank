package za.ac.cput.wisebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.wisebank.domain.Withdrawal;

import java.util.List;
import java.util.Optional;

@Repository

public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {


}
