package exceptions.person;

/*
Excepción personalizada para nombres inválidos.
 */

public class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}