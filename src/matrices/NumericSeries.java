package matrices;

/*
Dado una matriz de 5x5, realizar un algoritmo que lo rellene como en la figura:
0 1 2 3 4
1 2 3 4 3
2 3 4 3 2
3 4 3 2 1
4 3 2 1 0
 */

public class NumericSeries {
    public static void main(String[] args) {
        int[][] test = new int[5][5];
        fillMatrix(test);
        printMatrix(test);
    }

    static int[][] fillMatrix(int[][] matrix) {

        int num;

        for (int i = 0; i < matrix.length; i++) {
            num = i;
            int end = matrix.length - i;
            for (int j = 0; j <= matrix.length; j++) {
                if (j < end) {
                    matrix[i][j] = num;
                    num++;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int start = matrix.length - i;
            num = matrix.length - 2;
            for (int j = 0; j < matrix.length; j++) {
                if (j >= start) {
                    matrix[i][j] = num;
                    num--;
                }
            }
        }
        return matrix;
    }

    static void printMatrix(int[][] matrix) {

        for (int[] array : matrix) {
            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
