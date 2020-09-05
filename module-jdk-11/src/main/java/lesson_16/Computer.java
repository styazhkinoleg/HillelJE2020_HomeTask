package lesson_16;

import java.util.Arrays;
import java.util.Random;

public class Computer implements Player{
    @Override
    public Choices nextMove() {
        Choices [] objects = Choices.values();
        Random random = new Random();
        return objects[random.nextInt(objects.length - 1)];
    }
}
