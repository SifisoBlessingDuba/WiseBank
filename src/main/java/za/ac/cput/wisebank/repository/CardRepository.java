package za.ac.cput.wisebank.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.wisebank.domain.Card;
import java.util.List;
import java.util.Optional;
@Repository
public interface CardRepository extends JpaRepository<Card, String> {
    @Override
    Card save(Card card);

    @Override
    void deleteById(String cardNumber);

    @Override
    Optional<Card> findById(String cardNumber);

    @Override
    List<Card> findAll();
}
