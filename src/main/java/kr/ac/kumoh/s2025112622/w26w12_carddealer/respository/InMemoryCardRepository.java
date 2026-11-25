package kr.ac.kumoh.s2025112622.w26w12_carddealer.respository;

import kr.ac.kumoh.s2025112622.w26w12_carddealer.model.Card;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCardRepository implements CardRepository {
    private final List<Card> cards = new ArrayList<>();

    @Override
    public List<Card> getCards() {
        return List.copyOf(cards);
    }

    @Override
    public void save(Card card) {
        if (!cards.contains(card)) {
            cards.add(card);
        }
    }

    @Override
    public void deleteAll() {
        cards.clear();
    }
}
