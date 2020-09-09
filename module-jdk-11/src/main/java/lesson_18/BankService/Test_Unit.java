package lesson_18.BankService;

import lesson_18.BankService.Account;
import lesson_18.BankService.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.ArrayList;

public class Test_Unit {

    @Test
    void checkCardIsPinCorrect(){
        Card card = new Card("1", 1);
        assumeTrue(card.isPinCorrect(1));
        assumeFalse(card.isPinCorrect(2));
    }

    @Test
    void checkAccountAddCard(){
        Account acc = new Account("1");
        assumeTrue(acc.addCard(new Card("1")));
        assumeFalse(acc.addCard(new Card("1")));
    }

    @Test
    void checkAccountHaveCard() {
        Account acc = new Account("1");
        assumeFalse(acc.haveCard("1"));
        assumeTrue(acc.addCard(new Card("1")));
        assumeTrue(acc.haveCard("1"));

    }

    @Test
    void checkAccountCheckAccessByCard() {
        Account acc = new Account("1");
        assumeTrue(acc.addCard(new Card("1", 1)));
        assumeTrue(acc.checkAccessByCard("1", 1));
        assumeFalse(acc.checkAccessByCard("1", 2));
    }

    @Test
    void checkAccountRecharge() {
        Account acc = new Account("1");
        assumeTrue(acc.getAmount() == 0);
        assumeTrue(acc.recharge(100));
        assumeTrue(acc.getAmount() == 100);
    }

    @Test
    void checkAccountWithdraw() {
        Account acc = new Account("1");
        assumeFalse(acc.withdraw(1));
        assumeTrue(acc.recharge(100));
        assumeFalse(acc.withdraw(200));
        assumeTrue(acc.withdraw(80));
        assumeTrue(acc.getAmount() == 20);
    }

    @Test
    void checkBankServiceDBAddCardToAccount() {
        BankServiceDB db = new BankServiceDB();
        DataBase.DB.put("1", new Account("1"));
        DataBase.DB.put("2", new Account("2"));
        assumeTrue(db.addCardToAccount("1", new Card("1")));
        assumeFalse(db.addCardToAccount("1", new Card("1")));
        assumeFalse(db.addCardToAccount("2", new Card("1")));
        assumeTrue(db.addCardToAccount("2", new Card("2")));
        DataBase.DB.clear();
    }

    @Test
    void checkBankServiceDBRecharge() {
        BankServiceDB db = new BankServiceDB();
        DataBase.DB.put("1", new Account("1"));
        assumeTrue(db.getAccountAmount("1") == 0);
        assumeFalse(db.recharge("2", 100));
        assumeTrue(db.recharge("1", 100));
        assumeTrue(db.getAccountAmount("1") == 100);
        DataBase.DB.clear();
    }

    @Test
    void checkBankServiceDBWithdraw() {
        BankServiceDB db = new BankServiceDB();
        DataBase.DB.put("1", new Account("1"));
        assumeTrue(db.getAccountAmount("1") == 0);
        assumeFalse(db.withdraw("2", 100));
        assumeTrue(db.recharge("1", 100));
        assumeFalse(db.withdraw("1", 200));
        assumeTrue(db.withdraw("1", 100));
        assumeTrue(db.getAccountAmount("1") == 0);
        DataBase.DB.clear();
    }

    @Test
    void checkCardServiceRun() throws InterruptedException {
        byte result = 0;
        BankServiceDB db = new BankServiceDB();

        DataBase.DB.put("1", new Account("1"));
        db.addCardToAccount("1", new Card("1", 1));

        CardService cardService = new CardService("2", 0, 0, null);
        Thread thread = new Thread(cardService);
        thread.start();
        thread.join();
        result = cardService.getErrorCode();
        assumeTrue(result == 4);
        cardService = new CardService("2", 0, 0, Operation.RECHARGE);
        thread = new Thread(cardService);
        thread.start();
        thread.join();
        result = cardService.getErrorCode();
        assumeTrue(result == 4);
        cardService = new CardService("2", 0, 1, Operation.RECHARGE);
        thread = new Thread(cardService);
        thread.start();
        thread.join();
        result = cardService.getErrorCode();
        assumeTrue(result == 2);
        cardService = new CardService("1", 0, 1, Operation.RECHARGE);
        thread = new Thread(cardService);
        thread.start();
        thread.join();
        result = cardService.getErrorCode();
        assumeTrue(result == 3);
        cardService = new CardService("1", 1, 1, Operation.RECHARGE);
        thread = new Thread(cardService);
        thread.start();
        thread.join();
        result = cardService.getErrorCode();
        assumeTrue(result == 0);
        DataBase.DB.clear();
    }
}
