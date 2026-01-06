package exceptions.person;

/*
Ejercicio 5: Manejo de excepciones en herencia de clases (Nivel avanzado)
Descripción: Crea una jerarquía de clases donde una clase base lanza una excepción y
una clase derivada maneja esa excepción de una forma específica. Por ejemplo, una clase Employee
que hereda de Person, donde Person tiene un método que puede lanzar una excepción que Employee
maneja de una manera particular.

Requisitos:

Clase Person:
- Método setName(String name) que lanza una InvalidNameException si
el nombre es null o vacío.

Clase Employee (hereda de Person):
- Método setSalary(double salary) que lanza una InvalidSalaryException si el salario
es negativo.
- Sobreescritura del método setName que maneja InvalidNameException específicamente (por ejemplo, establece un nombre por defecto).

Excepciones personalizadas:
- InvalidNameException (extiende Exception).
- InvalidSalaryException (extiende Exception).

Clase Main:
- Crear una instancia de Employee y probar los métodos con datos válidos e inválidos.
- Manejar las excepciones apropiadamente.

Objetivos:
- Entender cómo las excepciones interactúan con la herencia de clases.
- Practicar la captura y manejo de excepciones en una jerarquía de clases.
- Implementar lógica de manejo de excepciones específica en clases derivadas.
 */

public class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) throws InvalidNameException {
        if (name == null || name.isEmpty()) {
            throw new InvalidNameException("Name cannot be empty or null");
        } else {
            this.name = name;
        }
    }
}