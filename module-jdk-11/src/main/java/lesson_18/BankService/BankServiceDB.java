package lesson_18.BankService;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

class BankServiceDB {

    boolean addCardToAccount(String accountId, Card card) {
        if (!cardAlreadyExist(card.getID())) {
            Account acc = getAccountByID(accountId);
            if (acc != null) {
                return acc.addCard(card);
            }
        }
        return false;
    }
    double getAccountAmount(String accountId) {
        Account acc = getAccountByID(accountId);
        if (acc != null) {
            return acc.getAmount();
        }
        return 0;
    }
    boolean recharge(String accountId, double sum){
        Account acc = getAccountByID(accountId);
        if (acc != null) {
            return acc.recharge(sum);
        }
        return false;
    }
    boolean withdraw(String accountId, double sum){
        Account acc = getAccountByID(accountId);
        if (acc != null) {
            return acc.withdraw(sum);
        }
        return false;
    }
    AnswerDB getDataByCardID(String cardID, int pin){
        for (Account acc : DataBase.DB.values()) {
            if (acc.haveCard(cardID)){
                AnswerDB answerDB = new AnswerDB();
                answerDB.AccountID = acc.getID();
                answerDB.CardAccess = acc.checkAccessByCard(cardID, pin);
                return answerDB;
            }
        }
        return null;
    }
    class AnswerDB{
        String AccountID;
        boolean CardAccess;
    }

    void generateDataBase() {
        int n = 10;
        Random random = new Random();

        // generate CARDS
        Set<Card> cards = new HashSet<>();
        while(cards.size() != 10)
            cards.add(new Card("5" + "XXXXX" + String.format("%09d",random.nextInt(999999999)) + "C"));
        // generate ACCOUNTS
        for (int i = 0; i < n; i++) {
            Card card = cards.stream().skip(i).findFirst().get();
            Account acc = new Account("UA" + "29" + "XXXXXX" + "00000XXXX" + String.format("%010d",random.nextInt(Integer.MAX_VALUE)));
            acc.recharge(1000);
            String id = acc.getID();
            DataBase.DB.put(id, acc);
            addCardToAccount(id, card);
            //acc.addCard(card);

        }
        // Create json for test
        Gson gson = new Gson();
        json_for_test(gson.toJson(cards));
    }

    private boolean cardAlreadyExist(String id) {
        return DataBase.DB.values().stream().anyMatch(x -> x.haveCard(id) == true);
    }
    private Account getAccountByID(String accountId){
       return DataBase.DB.get(accountId);
    }
    private void json_for_test(String jsonString) {
        String currentDirectory = null;
        try {
            currentDirectory = BankServiceDB.class.getResource(".").toURI().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        File log = new File(currentDirectory + "cards.json");
        try {
            FileOutputStream outStreamFile = new FileOutputStream(log);
            outStreamFile.write(jsonString.getBytes());
            outStreamFile.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}