package lesson_03;

import java.util.Scanner;

public class Pow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите основание");
        int x = scanner.nextInt();
        System.out.println("Введите степень");
        int n = scanner.nextInt();
        int result = x;
        for (int i = 0; i < n-1 ; i++) {
            result *= x;
        }
        System.out.printf("%d^%d = %d. (Проверка Math: %f)", x, n, result, Math.pow(x, n));
    }
}
