package External;

public class ExternalFunction {
    public ExternalFunction() {
    }
    public static int factorial(int value){
        if (value < 1) return 0;
        if (value == 1 ) {
            return value;
        }
        return value * factorial(--value);
    }
    public static int findElementOfArithmeticProgression(int firstTerm, int difference, int index) {
        return firstTerm + (index-1) * difference;
    }
    public static double findArithmeticMean(int [] array){
        double arithmeticMean = 0;
        if (array.length > 0) {
            long sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
            System.out.println("sum = " + sum + ". elements = " + array.length);
            arithmeticMean = (double) sum / array.length;
        }
        return arithmeticMean;
    }
    public static String getSeparator() {
        return "================================================================================";
    }
}
