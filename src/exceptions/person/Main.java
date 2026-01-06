package exceptions.person;

/*
Clase principal para probar las excepciones personalizadas.
 */

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Antonio", 2000);

        employee.setName(null);

        System.out.println(employee.name);

        employee.setName("Luis");

        System.out.println(employee.name);

        try {
            employee.setSalary(-5);
        } catch (InvalidSalaryException e) {
            throw new RuntimeException(e);
        }

        System.out.println(employee.salary);

        try {
            employee.setSalary(1500);
        } catch (InvalidSalaryException e) {
            throw new RuntimeException(e);
        }

        System.out.println(employee.salary);
    }
}