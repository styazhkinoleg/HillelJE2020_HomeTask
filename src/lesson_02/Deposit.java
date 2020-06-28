package lesson_02;

import java.util.Scanner;

public class Deposit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float account = 0;
        float percent = 0;
        int year = 0;

        int numberOfAttempted = 3;
        int n = 0;
        while (n<numberOfAttempted) {
            System.out.println("Сумма вклада:");
            float inputValue = scanner.nextFloat();
            if (inputValue > 0) {
                account = inputValue;
                break;
            }
            System.out.println("Сумма вклада должна быть больше 0");
            n++;
        }
        if (account == 0) return;

        n = 0;
        while (n<numberOfAttempted) {
            System.out.println("Процент годовых:");
            float inputValue = scanner.nextFloat();
            if (inputValue > 0) {
                percent = inputValue;
                break;
            }
            System.out.println("Процент годовых должен быть больше 0");
            n++;
        }
        if (percent == 0) return;

        n = 0;
        while (n<numberOfAttempted) {
            System.out.println("Срок вклада (лет):");
            int inputValue = scanner.nextInt();
            if (inputValue > 0) {
                year = inputValue;
                break;
            }
            System.out.println("Срок вклада должен быть больше 0");
            n++;
        }
        if (year == 0) return;

        float sumInvestmentInterest = account * percent / 100;

        System.out.println("Таблица начислений:");
        for (n = 0; n < year; n++) {
            System.out.printf("Сумма: %20.2f. | Сумма процентов: %20.2f", account, sumInvestmentInterest);
            account += sumInvestmentInterest;
            System.out.printf(". | Итого: %20.2f\n", account);
        }
        System.out.printf("К выплате : %.2f\n", account);
    }
}
