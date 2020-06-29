package lesson_03;

import External.ExternalFunction;

public class ArithmeticProgression {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.print(ExternalFunction.findElementOfArithmeticProgression(0, -5, i) + " ");
        }
    }
}
