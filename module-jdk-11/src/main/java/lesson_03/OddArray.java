package lesson_03;

public class OddArray {
    public static void main(String[] args) {
        int n = 10;
        int [] array = new int[n];

        for (int i = 0; i < array.length ; i++) {
            array[i] = 2*i + 1;
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }


    }
}
