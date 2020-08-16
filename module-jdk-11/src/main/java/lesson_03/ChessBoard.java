package lesson_03;

public class ChessBoard {
    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i % 2 == 0) {
                    System.out.print((j * 8 + j) % 2 == 0 ? "W " : "B ");
                }
                else {
                    System.out.print((j * 8 + j) % 2 == 0 ? "B " : "W ");
                }
            }
            System.out.println();
        }
    }
}
