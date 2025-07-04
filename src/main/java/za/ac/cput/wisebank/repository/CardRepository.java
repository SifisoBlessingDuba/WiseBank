package za.ac.cput.wisebank.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.wisebank.domain.Card;
import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Integer> {
    @Override
    Card save(Card card);

    @Override
    void deleteById(Integer cardId);

    @Override
    Optional<Card> findById(Integer cardId);

    @Override
    List<Card> findAll();
}
