package basic_programming;

/*
Crea un programa para calcular cuántos billetes se le entregan a un cliente.

El cliente solicita una cantidad específica de dinero de su banco.

Siempre calculamos la cantidad mínima de billetes.

Por ejemplo:

Para la cantidad de euros: 3475 €

6 billetes de 500 €
2 billetes de 200 €
0 billetes de 100 €
1 billete de 20 €
0 billetes de 10 €
1 billete de 5 €
 */

import java.util.Scanner;

public class Amount {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce la cantidad de dinero: ");
        int amount = sc.nextInt();

        int remaining = amount;

        int bills500 = remaining / 500;
        remaining %= 500;
        int bills200 = remaining / 200;
        remaining %= 200;
        int bills100 = remaining / 100;
        remaining %= 100;
        int bills50 = remaining / 50;
        remaining %= 50;
        int bills20 = remaining / 20;
        remaining %= 20;
        int bills10 = remaining / 10;
        remaining %= 10;
        int bills5 = remaining / 5;

        System.out.println("500 € bills: " + bills500);
        System.out.println("200 € bills: " + bills200);
        System.out.println("100 € bills: " + bills100);
        System.out.println(" 50 € bills: " + bills50);
        System.out.println(" 20 € bills: " + bills20);
        System.out.println(" 10 € bills: " + bills10);
        System.out.println("  5 € bills: " + bills5);

        sc.close();

    }
}