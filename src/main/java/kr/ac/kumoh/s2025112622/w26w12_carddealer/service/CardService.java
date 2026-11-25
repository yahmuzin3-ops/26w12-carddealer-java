package kr.ac.kumoh.s2025112622.w26w12_carddealer.service;

import kr.ac.kumoh.s2025112622.w26w12_carddealer.model.Card;
import kr.ac.kumoh.s2025112622.w26w12_carddealer.respository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class CardService {
    private final CardRepository repository;

    public CardService(CardRepository repository) {
        this.repository = repository;
    }

    public List<Card> getCards() {
        return repository.getCards();
    }

    public void dealCards() {
        dealCards(5);
    }

    public void dealCards(int count) {
        String[] suits = {"spades", "diamonds", "hearts", "clubs"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};

        repository.deleteAll();

        // 0~51 숫자를 섞은 뒤
        // count개만 뽑아서
        // 오름차순 정렬
        List<Integer> numbers = new ArrayList<>(IntStream.range(0, 52).boxed().toList());
        Collections.shuffle(numbers);
        List<Integer> picked = new ArrayList<>(numbers.subList(0, Math.min(count, numbers.size())));
        Collections.sort(picked);

        // 뽑힌 숫자(0~51)를 무늬(suit)와 숫자(rank)로 계산해서 저장
        for (int number : picked) {
            String suit = suits[number / ranks.length];
            String rank = ranks[number % ranks.length];
            repository.save(new Card(rank, suit));
        }
    }
}
