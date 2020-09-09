package lesson_18.ATM;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lesson_18.Adapter;
import lesson_18.BankService.CardService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AtmService {

    private List<Card> cards = new ArrayList();

    public AtmService() {
        String currentDirectory = null;
        Gson gson = new Gson();
        Type type = new TypeToken<List<Card>>() {}.getType();
        try {
            currentDirectory = CardService.class.getResource(".").toURI().getPath();
            cards = gson.fromJson(new FileReader(currentDirectory + "cards.json"), type);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void Emulate(){
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            makeOperation(cards.get(random.nextInt(cards.size()-1)), (byte) (random.nextInt(3) % 3));
        }
    }

    private void makeOperation(Card card, byte op) {
        if(op == 0){
            // operation recharge
            Adapter.recharge(card, 100);
        } else {
            // operation cash
            Adapter.cash(card, 50);
        }
    }

    public class Card{
        public String ID;
        public int pin;
    }

}
