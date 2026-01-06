package matrices;

import java.util.Scanner;

public class CinemaMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CinemaTickets cinema = new CinemaTickets();
        int row = 0;

        while (row != 10) {
            cinema.display();

            System.out.print("Introduce fila (1-10, 0 para salir): ");
            row = scanner.nextInt();

            System.out.print("¿Cuántas entradas quieres? ");
            int quantity = scanner.nextInt();

            boolean sold = cinema.sellTickets(row, quantity);

            if (sold) {
                System.out.println("¡Entradas vendidas!");
            } else {
                System.out.println("No hay suficientes asientos juntos en esa fila.");
            }
        }

        scanner.close();
    }
}
