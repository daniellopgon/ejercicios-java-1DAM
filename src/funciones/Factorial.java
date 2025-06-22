package funciones;

/*
Método factorial(), que calculará el factorial del número que se le pasa como parámetro.
Retornará el resultado del cálculo del factorial, o bien un -1 en caso de que el parámetro
pasado sea negativo, y un -2 en caso de que el parámetro pasado sea cero.
Escribe el método inverso(), que recibe un numero y retorna el inverso
(si recibe el 1234 da como retorno el 4321). Prohibido usar método reverse().
 */

public class Factorial {

    public static void main(String[] args) {

        int numero = 5;

        System.out.println("El factorial del número es: " + factorial(numero));

    }

    static int factorial(int numero) {

        int factorial = 1;
        int resultado = 0;

        if (numero < 0) {
            return -1;
        } else if (numero == 0) {
            return 1;
        } else {
            for (int i = 1; i <= numero; i++) {
                resultado = factorial *= i;
            }
        }
        return resultado;
    }
}
