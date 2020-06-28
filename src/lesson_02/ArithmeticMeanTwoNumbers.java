package lesson_02;

public class ArithmeticMeanTwoNumbers {
    public static void main(String[] args) {
        ArithmeticMean arithmeticMean = new ArithmeticMean(100, 50);
        System.out.printf("Arithmetic mean = %.2f", arithmeticMean.findArithmeticMean());
    }
}
