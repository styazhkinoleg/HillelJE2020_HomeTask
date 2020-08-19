package lesson_13;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class StreamArithmeticMean {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите элементы Integer через пробел");
        String res = scanner.nextLine();
        var list = new ArrayList<Integer>();
        for (String el: res.split(" ")){
            try{
                list.add(Integer.valueOf(el));
            }
            catch (NumberFormatException e){
                System.out.println("Ошибка ввода данных. Элементами могут быть только числа");
                return;
            };
        }
        System.out.print("Среднее значение ");
        list.stream().peek(x -> x.toString()).forEach(x -> System.out.print(x + " "));
        System.out.printf("= %.2f", list.stream().mapToInt(x -> x).average().getAsDouble());
    }

}
