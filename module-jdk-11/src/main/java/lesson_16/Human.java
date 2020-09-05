package lesson_16;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Human implements Player{
    @Override
    public Choices nextMove() {
        Scanner scanner = new Scanner(System.in);
        var choices = Arrays.stream(Choices.values()).collect(Collectors.toList());
        int choice = 0;
        while (choice == 0) {
            System.out.println("Choice menu:");
            choices.stream().forEach((x) -> System.out.printf("%d - %s\n", choices.indexOf(x) + 1, x));
            System.out.println("0 - Exit game");
            System.out.print("Make your choice: ");
            try {
                choice = scanner.nextInt();
                if (choice == 0)
                    return null;
                else if (choice < 1 || choice > choices.size()){
                    choice = 0;
                    throw new InputMismatchException();                }

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Wrong value. Please repeat!");
            }
        }
        return choices.get(choice - 1);
    }
}
