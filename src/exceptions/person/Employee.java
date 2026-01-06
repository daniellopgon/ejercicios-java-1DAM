package exceptions.person;

/*
Clase Employee que hereda de Person y maneja excepciones de salario.
 */

public class Employee extends Person {
    double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public void setSalary(double salary) throws InvalidSalaryException {
        if (salary <= 0) {
            throw new InvalidSalaryException("Salary cannot be zero or negative");
        } else {
            this.salary = salary;
        }
    }

    @Override
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            this.name = "UNIDENTIFIED";
        } else {
            this.name = name;
        }
    }
}