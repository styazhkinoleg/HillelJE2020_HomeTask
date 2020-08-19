package lesson_13;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListPairCollections {
    public static void main(String[] args) {
        final String inputEnd = "-end";
        Scanner scanner = new Scanner(System.in);
        var list = new ArrayList<String>();
        System.out.println("Введите строки коллекции. Для окончания ввода наберите " + inputEnd);
        while (!scanner.hasNext(inputEnd)){
            list.addAll(Arrays.stream(scanner.nextLine().trim().split(" ")).filter(x -> x.length() != 0).collect(Collectors.toList()));
        }
        List<Pair> listPair = list.stream().map(x -> new Pair(x, x.toUpperCase())).collect(Collectors.toList());
        listPair.stream().forEach(System.out::println);

    }
}

class Pair <L,R>{
    L left;
    R right;

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.format("{%s:%s}",left,right);
    }
}
