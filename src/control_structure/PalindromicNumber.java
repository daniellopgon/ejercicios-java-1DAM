package control_structure;

/*
Crea un programa que imprima si un número es capicúa o no.

Usa un límite de 10.000 y estructuras if-else anidadas.
 */

import java.util.Scanner;

public class PalindromicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número: ");
        int number = sc.nextInt();

        boolean capicua = false;

        if (number >= 10 && number < 10000) {
            int original = number;
            int reversed = 0;

            while (number > 0) {
                reversed = reversed * 10 + number % 10;
                number = number / 10;
            }

            capicua = (original == reversed);
        }

        System.out.println("Es capicua: " + capicua);

        sc.close();
    }

}
