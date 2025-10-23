package za.ac.cput.wisebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.wisebank.domain.Withdrawal;

import java.util.List;
import java.util.Optional;

@Repository

public interface WithdrawalRepository extends JpaRepository<Withdrawal, Long> {


}
//guys check if this page will show up in the final project
//50