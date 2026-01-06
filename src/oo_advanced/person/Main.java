package oo_advanced.person;

/*
Clase principal para probar las clases Person, Teacher, SubstituteTeacher y TenuredTeacher.
 */

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el nombre: ");
        String name = sc.nextLine();

        System.out.println("Introduce el sexo (H/M): ");
        char gender = sc.next().charAt(0);

        System.out.println("Introduce la edad: ");
        int age = sc.nextInt();

        System.out.println("Introduce el peso: ");
        double weight = sc.nextDouble();

        System.out.println("Introduce la altura: ");
        double height = sc.nextDouble();

        Person person1 = new Person(name, age, gender, weight, height);
        Person person2 = new Person("Laura", 23, 'M');
        Person person3 = new Person("Marcos");

        Person[] people = { person1, person2, person3 };

        for (Person p : people) {
            int bmi = p.calculateBMI();
            System.out.print(p.getName() + " tiene un IMC: ");
            switch (bmi) {
                case Person.UNDERWEIGHT -> System.out.println("Bajo peso");
                case Person.NORMAL -> System.out.println("Peso normal");
                case Person.OVERWEIGHT -> System.out.println("Sobrepeso");
                default -> System.out.println("No calculable");
            }

            System.out.println(p.getName() + (p.isAdult() ? " es mayor de edad" : " es menor de edad"));
            System.out.println(p);
            System.out.println();
        }

        SubstituteTeacher substitute = new SubstituteTeacher("Jose", 35, 'H', 75, 1.80,
                "Programación", "Entornos", "Sistemas", "BD",
                LocalDate.of(2023, 9, 1));

        TenuredTeacher tenured = new TenuredTeacher("Ana", 40, 'M', 65, 1.70,
                "Programación", "FOL", "Interfaces", "Acceso a datos",
                LocalDate.of(2020, 6, 15));

        System.out.println("--- PROFESORES ---");
        System.out.println(substitute);
        System.out.println(substitute.getInterimStartDate());

        System.out.println(tenured);
        System.out.println(tenured.getExamDateInfo());
    }

}
