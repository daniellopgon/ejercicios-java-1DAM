package matrices;

/*
Sistema de venta de entradas de cine con gestión de asientos.
Usa una matriz para representar las butacas de la sala.
 */

public class CinemaTickets {

    int rows = 10;
    int columns = 12;
    char[][] seats;

    public CinemaTickets() {
        seats = new char[rows][columns];
        initialize();
    }

    public void initialize() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = '_';
            }
        }
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean sellTickets(int row, int quantity) {

        int counter = 0;
        int start = 0;

        for (int column = 0; column < seats[0].length; column++) {
            if (seats[row][column] != 'X') {
                if (counter == 0) {
                    start = column;
                }
                counter++;
                if (counter == quantity) {
                    for (int i = start; i < start + quantity; i++) {
                        seats[row][i] = 'X';
                    }
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

}
