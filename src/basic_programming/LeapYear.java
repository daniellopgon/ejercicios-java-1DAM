package basic_programming;

/*
Crea un programa que determine si un año es bisiesto.

Un año bisiesto es divisible entre cuatro, excepto los años seculares.

Los años seculares terminan en 00, en cuyo caso también deben ser divisibles entre cuatrocientos.
*/

import java.util.Scanner;

public class LeapYear {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el año:");
        int year = sc.nextInt();

        boolean leapYear = year % 400 == 0 || year % 4 == 0 || year % 100 != 0;

        if (leapYear) {
            System.out.println("El año es bisiesto");
        } else {
            System.out.println("El año no es bisiesto");
        }

        sc.close();
    }

}
