package lesson_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterList {
    public static void main(String[] args) {
        final String inputEnd = "-end";
        Scanner scanner = new Scanner(System.in);
        var list = new ArrayList<String>();
        System.out.println("Введите строки коллекции. Для окончания ввода наберите " + inputEnd);
        while (!scanner.hasNext(inputEnd)){
            list.addAll(Arrays.stream(scanner.nextLine().trim().split(" ")).filter(x -> x.length() != 0).collect(Collectors.toList()));
        }
        System.out.print("Исходная коллекия: ");
        System.out.println(list);
        System.out.print("Результат: ");
        Predicate <String> isLoverCase = x -> x == x.toLowerCase();
        Predicate <String> isFourLetters = x -> x.length() == 4;
        list.stream().filter(isLoverCase.and(isFourLetters)).distinct().forEach(x -> System.out.print(x + " "));
        System.out.println();
    }
}
