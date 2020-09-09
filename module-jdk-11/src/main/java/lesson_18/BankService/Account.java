package lesson_18.BankService;

import java.util.ArrayList;
import java.util.List;

class Account {
    private String ID;
    private List<Card> cards;
    private double amount;

    public Account(String id) {
        ID = id;
        cards = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }
    public double getAmount() {
        return amount;
    }

    public boolean addCard(Card card){
        if(!this.haveCard(card.getID()))
            return cards.add(card);
        return false;
    }
    public boolean haveCard(String id) {
        return this.cards.stream().anyMatch(x -> x.getID().equals(id));
    }
    public boolean checkAccessByCard (String id, int pin){
        return this.cards.stream().filter(x -> x.getID().equals(id)).findFirst().get().isPinCorrect(pin);
    }
    public boolean recharge(double sum){
        amount += sum;
        return true;
    }
    public boolean withdraw(double sum){
        if(amount >= sum) {
            amount -= sum;
            return true;
        }
        return false;
    }
}
