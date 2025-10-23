package za.ac.cput.wisebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.wisebank.domain.Card;
import za.ac.cput.wisebank.repository.CardRepository;

import java.util.List;

@Service
public class CardService implements ICardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card update(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void deleteById(String id) {
        cardRepository.deleteById(id);

    }

    @Override
    public Card findById(String id) {
        return cardRepository.findById(id).orElse(null);
    }
    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }
}
//guys check if this page will show up in the final project
//58
