package control_structure;

/*
Crea un menú para una calculadora simple.
 */

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option;

        System.out.println("Introduce 2 números: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        do {
            System.out.println("""
                    MENU:
                    1- sumar
                    2- restar
                    3- dividir
                    4- multiplicar
                    5- salir
                    """);

            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println(a + b);
                    break;
                case 2:
                    System.out.println(a - b);
                    break;
                case 3:
                    System.out.println(b > 0 ? a / b : "El divisor tiene que ser mayor que 0");
                    break;
                case 4:
                    System.out.println(a * b);
                    break;
                case 5:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Introduce una opción correcta");
                    break;
            }
        } while (option != 5);

        sc.close();
    }

}
