package lesson_18;

import lesson_18.ATM.AtmService;
import lesson_18.BankService.CardService;
import lesson_18.BankService.Operation;

import static lesson_18.BankService.Operation.*;

public class Adapter {
    public static void cash(AtmService.Card card, double sum){
        CardService cs = new CardService(card.ID, card.pin, sum, WITHDRAW);
        Thread thread = new Thread(cs);
        thread.start();
    }
    public static void recharge(AtmService.Card card, double sum){
        CardService cs = new CardService(card.ID, card.pin, sum, RECHARGE);
        Thread thread = new Thread(cs);
        thread.start();
    }
}
