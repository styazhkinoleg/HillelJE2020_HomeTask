package lesson_14;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        testBoodleSortAndBinarySearch();
        System.out.println();
        testInsertSortAndInterpolationSearch();

    }

    public static void testBoodleSortAndBinarySearch(){
        Scanner scanner = new Scanner(System.in);

        int n = 30;
        List <Integer> list = Stream.generate(() -> (int) (Math.random() * 100))
                .limit(n).collect(Collectors.toList());

        System.out.println(list);
        list = Sort.bubbleSort(list);
        System.out.println(list);

        System.out.print("Введите элемент для поиска: ");
        Integer find = scanner.nextInt();
        int result = Search.binarySearch(list, find);
        System.out.println( result == -1
                ? String.format("%d не найден", find)
                : String.format("Индекс %d = %d\n", find, result ));

        List <String> listString = Arrays.asList("Input", "Data", "To", "Start");

        System.out.println(listString);
        listString = Sort.bubbleSort(listString);
        System.out.println(listString);

        String [] searchCollection = {"To", "to"};
        for (var str: searchCollection) {
            result = Search.binarySearch(listString, str);
            System.out.println( result == -1
                    ? String.format("%s не найден", str)
                    : String.format("Индекс %s = %d", str, result ));
        }
    }
    public static void testInsertSortAndInterpolationSearch(){
        Scanner scanner = new Scanner(System.in);

        int n = 30;
        List <Integer> list = Stream.generate(() -> (int) (Math.random() * 100))
                .limit(n).collect(Collectors.toList());

        System.out.println(list);
        list = Sort.insertSort(list);
        System.out.println(list);

        System.out.print("Введите элемент для поиска: ");
        Integer find = scanner.nextInt();

        int result = Search.interpolationSearch(list, find);
        System.out.println( result == -1
                ? String.format("%d не найден", find)
                : String.format("Индекс %d = %d\n", find, result ));
    }
}
