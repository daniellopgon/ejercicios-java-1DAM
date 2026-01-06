package arrays;

/*
Encuentra el número positivo más pequeño que sea divisible por todos
los números del 1 al 20.

Nota: 2520 es el número más pequeño que puede dividirse por cada uno de
los números del 1 al 10 sin resto.
 */
public class LCMCalculator {

    private static final int UPPER_LIMIT = 20;

    public static void main(String[] args) {
        long result = findSmallestCommonMultiple(UPPER_LIMIT);
        System.out.println("The smallest positive number divisible by all numbers from 1 to "
                + UPPER_LIMIT + " is: " + result);
    }

    public static long findSmallestCommonMultiple(int limit) {
        if (limit < 1) {
            throw new IllegalArgumentException("Limit must be positive");
        }

        long result = 1;

        for (int i = 2; i <= limit; i++) {
            result = calculateLCM(result, i);
        }

        return result;
    }

    public static long calculateLCM(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        a = Math.abs(a);
        b = Math.abs(b);

        return (a / calculateGCD(a, b)) * b;
    }

    public static long calculateGCD(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}