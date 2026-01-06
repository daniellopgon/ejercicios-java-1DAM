package exceptions;

/*
Ejercicio 3: Captura de múltiples excepciones (Nivel medio)
Descripción: Crea una clase llamada DataProcessor con un método processInput que realiza las siguientes operaciones:

- Leer una línea de texto de la consola.
- Convertir la línea leída a un entero.
- Dividir 100 entre el número introducido.

Implementa el manejo de excepciones para capturar posibles errores que puedan ocurrir durante estas operaciones, como:

- IOException: Si ocurre un error al leer la entrada de la consola.
- NumberFormatException: Si la entrada no puede convertirse a entero.
- ArithmeticException: Si se intenta dividir por cero.

Requisitos:
- Usa un bloque try que englobe las operaciones mencionadas.
- Implementa múltiples bloques catch para manejar cada tipo de excepción específicamente.
- Muestra mensajes de error claros y descriptivos para cada excepción capturada.
- Añade un bloque finally que imprima un mensaje indicando que el proceso ha terminado, independientemente de si ocurrió una excepción o no.

Objetivos:
- Manejar múltiples excepciones específicas en el mismo bloque try-catch.
- Entender la importancia de capturar excepciones específicas para proporcionar respuestas apropiadas a diferentes errores.
- Usar el bloque finally para realizar acciones que siempre deben ejecutarse, como limpieza o notificaciones finales.
 */

import java.util.Scanner;

public class DataProcessor {

    public void processInput() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter an integer: ");
            String input = scanner.nextLine();

            int number = Integer.parseInt(input);

            int result = 100 / number;

            System.out.println("Result of 100 divided by " + number + " is: " + result);

        } catch (NumberFormatException e) {
            System.out.println("Error: Input is not a valid integer.");

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero not allowed.");

        } finally {
            System.out.println("Process finished.");
            scanner.close();
        }
    }

    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();
        processor.processInput();
    }
}