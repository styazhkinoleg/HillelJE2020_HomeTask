package lesson_02;

public class ArithmeticMean {
    private int [] array;

    public ArithmeticMean(int a, int b){
        this.array = new int[] {a,b};
    }
    public ArithmeticMean(int[] array) {
        this.array = array;
    }
    public double findArithmeticMean(){
        double arithmeticMean = 0;
        if (array.length > 0) {
            long sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum += this.array[i];
            }
            System.out.println("sum = " + sum);
            arithmeticMean = (double) sum / array.length;
        }
        return arithmeticMean;
    }
}
