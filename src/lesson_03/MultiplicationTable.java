package lesson_03;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int x = scanner.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%2d x %d = %d\n", i, x, i * x);
        }
    }
}
