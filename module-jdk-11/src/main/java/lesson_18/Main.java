package lesson_18;

import lesson_18.ATM.AtmService;
import lesson_18.BankService.CardService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CardService cs = new CardService("0", 0, 0, null);
        cs.generateDataBase();
        cs.showDBInfo();
        AtmService atm = new AtmService();
        atm.Emulate();
        Thread.sleep(1000);
        System.out.println();
        cs.showDBInfo();
    }
}
