package za.ac.cput.wisebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.wisebank.domain.Card;
import za.ac.cput.wisebank.repository.CardRepository;
import za.ac.cput.wisebank.service.CardService;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }
    @PostMapping("/save")
    public Card save (@RequestBody Card card) {
        return cardService.save(card);
    }

    @PutMapping("/update")
    public Card update (@RequestBody Card card) {
        return cardService.save(card);
    }
    @DeleteMapping("/deleteCard{id}")
    public void deleteById (@PathVariable String id) {
        cardService.deleteById(id);
    }
    @GetMapping("/rad_card{id}")
    public Card findById (@PathVariable String id) {
        return cardService.findById(id);
    }
    @GetMapping("/all_cards")
    public List<Card> findAll () {
        return cardService.findAll();
    }

}
