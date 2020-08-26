package lesson_15;

import java.util.Arrays;

public class PseudoGraphics {
    private Numeral [] numerals;

    public PseudoGraphics(String str) {
        numerals = new Numeral[str.length()];
        int i = 0;
        for (char ch : str.toCharArray()) {
            numerals[i++] = new Numeral(ch);
        }
    }
    public void show() {
        for (int i = 0; i < 9; i++){
            System.out.println(getString(i));
        }
    }
    private String getString(int i) {
        String result = "         ".substring(0, i);
        for (Numeral ob : numerals) {
            result = result + ob.getLine(i);
        }
        return result;

    }
}
