package kr.ac.kumoh.s2025112622.w26w12_carddealer.respository;

import kr.ac.kumoh.s2025112622.w26w12_carddealer.model.Card;

import java.util.List;

public interface CardRepository {
    List<Card> getCards();

    void save(Card card);

    void deleteAll();
}
