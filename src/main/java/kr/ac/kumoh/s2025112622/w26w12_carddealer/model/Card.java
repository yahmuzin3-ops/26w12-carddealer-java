package kr.ac.kumoh.s2025112622.w26w12_carddealer.model;

public record Card(String rank, String suit) {

    public String getImageName() {
        return switch (rank) {
            case "jack", "queen", "king" -> rank + "_of_" + suit + "2.png";
            default -> rank + "_of_" + suit + ".png";
        };
    }
}
