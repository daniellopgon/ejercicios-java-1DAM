package arrays;

import java.util.Arrays;

/*
Programa que calcula la mediana de una serie numérica.
La mediana es el valor central en una lista ordenada de números.
 */
public class MedianCalculator {

    public static void main(String[] args) {
        int[] numbers = { 12, 23, 4, 6, 21, 11 };

        System.out.println("Original array: " + Arrays.toString(numbers));

        double median = calculateMedian(numbers);
        System.out.println("The median is: " + median);

        demonstrateWithDifferentArrays();
    }

    public static double calculateMedian(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int[] sortedNumbers = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedNumbers);

        int length = sortedNumbers.length;

        if (length % 2 == 0) {
            int middleIndex1 = length / 2 - 1;
            int middleIndex2 = length / 2;
            return (sortedNumbers[middleIndex1] + sortedNumbers[middleIndex2]) / 2.0;
        } else {
            return sortedNumbers[length / 2];
        }
    }

    public static double calculateMedianWithManualSort(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int[] sortedNumbers = selectionSort(Arrays.copyOf(numbers, numbers.length));

        int length = sortedNumbers.length;

        if (length % 2 == 0) {
            return (sortedNumbers[length / 2 - 1] + sortedNumbers[length / 2]) / 2.0;
        } else {
            return sortedNumbers[length / 2];
        }
    }

    public static int[] selectionSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }

        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void demonstrateWithDifferentArrays() {
        System.out.println("\n--- Additional Examples ---");

        int[][] testArrays = {
                { 1, 2, 3, 4, 5 },
                { 10, 20, 30, 40 },
                { 7 },
                { 5, 2, 8, 1, 9, 3 }
        };

        for (int[] testArray : testArrays) {
            System.out.println("Array: " + Arrays.toString(testArray) +
                    " -> Median: " + calculateMedian(testArray));
        }
    }
}