package matrices;

/*
Comprobar si un array de 5x5 es un cuadro mágico.
Se considera un cuadro mágico aquel en el que las filas, las columnas y
las diagonales suman igual.
 */

import java.util.Random;

public class MagicSquare {
    public static void main(String[] args) {
        Random r = new Random();
        int[][] test = new int[5][5];

        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test.length; j++) {
                test[i][j] = r.nextInt(10);
            }
        }

        printMatrix(test);

        if (isMagicSquare(test)) {
            System.out.println(" Es un cuadrado mágico ");
        } else {
            System.out.println(" No es un cuadrado mágico ");
        }

    }

    static boolean isMagicSquare(int[][] matrix) {
        int rows = sumRows(matrix);
        int columns = sumColumns(matrix);
        int diagonals = sumDiagonals(matrix);

        return diagonals == rows && columns == diagonals;

    }

    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int sumRows(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[0][i];
        }

        return sum;

    }

    static int sumColumns(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            sum += matrix[i][0];
        }

        return sum;
    }

    static int sumDiagonals(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }

        return sum;
    }
}
