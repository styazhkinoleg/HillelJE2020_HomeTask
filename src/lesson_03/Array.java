package lesson_03;

import External.ExternalFunction;

public class Array {
    public static void main(String[] args) {
        int n = 100;
        int [] array = new int [n];

        // generate elements
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) ((Math.random() * 100) * (i % 4 ==0 ? -1: 1));
        }

        printArray(array);
        System.out.println();

        int [] arrayMinIndex = new int [0], arrayMaxIndex = new int [0];
        int min = array[0], max = array[0];

        // find minimum & maximum
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
            if (max < array[i]) {
                max = array[i];
            }
        }

        // find indexes min & max element
        for (int i = 0; i < array.length; i++) {
            if (array[i] == min) {
                arrayMinIndex = AddToArray(arrayMinIndex, i);
            }
            if (array[i] == max) {
                arrayMaxIndex = AddToArray(arrayMaxIndex, i);
            }
        }

        // print min & max
        System.out.println("Minimum:");
        for (int i = 0; i < arrayMinIndex.length; i++) {
            System.out.printf("array[%d] = %d\n", arrayMinIndex[i], array[arrayMinIndex[i]]);
        }
        System.out.println();
        System.out.println("Maximum:");
        for (int i = 0; i < arrayMaxIndex.length; i++) {
            System.out.printf("array[%d] = %d\n", arrayMaxIndex[i], array[arrayMaxIndex[i]]);
        }
        System.out.println();

        // первые минимальные меняем на последние максимальные
        int j = Math.min(arrayMinIndex.length, arrayMaxIndex.length);
        int buf = 0;
        for (int i = 0; i < j; i++) {
            if (j == arrayMinIndex.length) {
                buf = array[arrayMinIndex[i]];
                array[arrayMinIndex[i]] = array[arrayMaxIndex[(arrayMaxIndex.length - 1) - i]];
                array[arrayMaxIndex[(arrayMaxIndex.length - 1) - i]] = buf;
            }
            else {
                buf = array[arrayMaxIndex[i]];
                array[arrayMaxIndex[i]] = array[arrayMinIndex[(arrayMinIndex.length - 1) - i]];
                array[arrayMinIndex[(arrayMinIndex.length - 1) - i]] = buf;
            }

        }

        printArray(array);
        System.out.println();

        System.out.printf("Arithmetic mean = %.2f", ExternalFunction.findArithmeticMean(array));

    }
    static void printArray(int [] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    static int[] AddToArray(int [] array, int element)
    {
        int [] newArray = new int [array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = element;
        return newArray;
    }
}
