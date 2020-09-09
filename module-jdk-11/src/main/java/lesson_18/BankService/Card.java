package lesson_18.BankService;

import java.util.Random;

class Card {
    private String ID;
    private int pin;

    public Card(String ID) {
        Random random = new Random();
        this.ID = ID;
        pin = random.nextInt(9999);
    }
    public Card(String ID, int pin) {
        this.ID = ID;
        this.pin = pin;
    }

    public String getID() {
        return ID;
    }
    public boolean isPinCorrect(int pin){
        return this.pin == pin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (!ID.equals(card.ID)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }
}
