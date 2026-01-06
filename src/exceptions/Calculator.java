package exceptions;

/*
Ejercicio 1: Manejo básico de excepciones (Nivel fácil)
Descripción: Crea una clase llamada Calculator con un método divide que recibe dos enteros y devuelve el resultado de la división.
Implementa el manejo de excepciones para capturar posibles divisiones por cero y mostrar un mensaje de error apropiado.

Requisitos:
- Usa un bloque try-catch para manejar ArithmeticException.
- Muestra un mensaje como "Error: La división por cero no está permitida." cuando ocurra la excepción.

Objetivos:
- Entender cómo capturar y manejar una excepción específica.
- Prevenir que el programa se cierre abruptamente debido a una excepción no manejada.
 */

public class Calculator {
    public static void main(String[] args) {
        double a = 12.6;
        double b = 23.8;

        try {
            System.out.println("The result is: " + divide(b, a));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("Exception test: " + divide(10, 0));
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero not allowed.");
        }
    }

    static double divide(double dividend, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisor cannot be zero");
        } else {
            return dividend / divisor;
        }
    }
}