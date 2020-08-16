package lesson_03;

import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args) {
        // loop odd numbers
        for (int i = 1; i < 100; i+=2) {
            System.out.print(i + " ");
        }
        System.out.println();
        // factorial
        Scanner scanner = new Scanner(System.in);
        int factorial = 1;
        System.out.println("Введите число");
        int n = scanner.nextInt();
        for (int i = 1; i <= n ; i++){
            factorial *= i;
        }
        System.out.printf("%d! = %d\n", n, factorial);
    }
}
