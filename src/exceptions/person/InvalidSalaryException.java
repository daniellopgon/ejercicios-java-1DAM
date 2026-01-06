package exceptions.person;

/*
Excepción personalizada para salarios inválidos.
 */

public class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}