package lesson_10;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите по очереди коэффициенты a,b,c квадратного уравнения ax^2 + bx + c = 0");
        System.out.print("a = ");
        int a = scanner.nextInt();
        System.out.print("b = ");
        int b = scanner.nextInt();
        System.out.print("c = ");
        int c = scanner.nextInt();
        System.out.println();
        System.out.printf("%dx^2 %s %dx %s %d = 0\n", a,
                (b < 0) ? "-" : "+", (b < 0) ? -b : b,
                (c < 0) ? "-" : "+", (c < 0) ? -c : c);

        long D = b * b - 4 * a * c;
        if (D < 0){
            System.out.println("Дискриминант меньше 0. Корней нет.");
        } else {
            if (D == 0) {
                System.out.printf("x1 = x2 = %.2f\n", (double)(-b / (2 * a)));
            } else {
                System.out.printf("x1 = %.2f\n", (double)((-b + Math.sqrt(D)) / (2 * a)));
                System.out.printf("x2 = %.2f\n", (double)((-b - Math.sqrt(D)) / (2 * a)));
            }
        }
    }
}
