package lesson_03;

import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {
        // loop odd numbers
        int i = 1;
        while (i < 100){
            System.out.print(i + " ");
            i += 2;
        }
        System.out.println();
        // factorial
        Scanner scanner = new Scanner(System.in);
        int factorial = 1;
        System.out.println("Введите число");
        int n = scanner.nextInt();
        i = 1;
        while (i <= n) {
            factorial *= i++;
        }
        System.out.printf("%d! = %d\n", n, factorial);
    }
}
