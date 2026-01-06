package control_structure;

/*
Muestra los primeros N términos de la serie de Fibonacci, donde N es un entero positivo.

Por ejemplo, si N = 10, la secuencia es:

0, 1, 1, 2, 3, 5, 8, 13, 21, 34
 */

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("n debe ser >= 0");
            return;
        }

        int prev = 0, curr = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(prev + (i < n - 1 ? " " : ""));
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        System.out.println();

        sc.close();
    }

}
