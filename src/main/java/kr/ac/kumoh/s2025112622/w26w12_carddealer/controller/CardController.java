package kr.ac.kumoh.s2025112622.w26w12_carddealer.controller;

import kr.ac.kumoh.s2025112622.w26w12_carddealer.model.Card;
import kr.ac.kumoh.s2025112622.w26w12_carddealer.service.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CardController {
    private final CardService service;

    public CardController(CardService service) {
        this.service = service;
    }

    @GetMapping("/cards/random")
    public String getRandomCards(Model model) {
        service.dealCards();

        List<String> cards = service.getCards().stream()
                .map(Card::getImageName)
                .toList();

        model.addAttribute("cards", cards);
        return "cards";
    }
}
