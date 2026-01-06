package lambda;

/*
Crea una lista de objetos Alumno, cada uno con los atributos nombre, notaMedia, y curso.

Usa funciones lambda con Stream para obtener la lista de alumnos que están en 1º DAM y tienen una nota media mayor de 8.0.

Calcula la nota media general de todos los alumnos usando un mapToDouble + average.

Ordena la lista de alumnos alfabéticamente por nombre usando una expresión lambda con Comparator.
 */

import java.util.ArrayList;

public class Student {
    private String name;
    private double averageGrade;
    private String course;

    public Student(String name, double averageGrade, String course) {
        this.name = name;
        this.averageGrade = averageGrade;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public String getCourse() {
        return course;
    }

    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Javi", 6.78, "DAM1"));
        studentList.add(new Student("Marcos", 8.35, "DAM1"));
        studentList.add(new Student("Marta", 3.82, "DAM2"));
        studentList.add(new Student("Laura", 5.68, "DAW1"));

        System.out.println(" ALUMNOS DE DAM1 CON > 8 DE MEDIA ");
        studentList.stream()
                .filter(s -> s.getCourse().equals("DAM1") && s.getAverageGrade() > 8)
                .forEach(s -> System.out.println(s.getCourse() + " " + s.getName() + " " + s.getAverageGrade()));

        System.out.println(" NOTA MEDIA ALUMNOS ");
        double studentsAverageGrade = studentList.stream()
                .mapToDouble(Student::getAverageGrade)
                .average()
                .orElse(0.0);
        System.out.println("la nota media es" + studentsAverageGrade);

        System.out.println(" ALUMNOS ORDENADOS POR NOMBRE: ");
        studentList.stream()
                .sorted((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()))
                .forEach(s -> System.out.println(s.getName() + " - " + s.getAverageGrade()));
    }
}
