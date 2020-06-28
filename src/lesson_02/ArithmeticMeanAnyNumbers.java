package lesson_02;

public class ArithmeticMeanAnyNumbers {
    public static void main(String[] args) {
        int n = 10;
        int i;
        int [] arr = new int[n];

        // generate numbers
        for (i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }

        ArithmeticMean arithmeticMean = new ArithmeticMean(arr);

        System.out.print("Numbers: ");
        for (int element : arr) {
            System.out.printf("%d ", element);
        }
        System.out.println();

        System.out.printf("Arithmetic mean = %.2f", arithmeticMean.findArithmeticMean());
    }
}
