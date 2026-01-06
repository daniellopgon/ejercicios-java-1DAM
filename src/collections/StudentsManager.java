package collections;

/*
Gestor de estudiantes usando HashSet.
Permite añadir, eliminar, buscar y mostrar estudiantes de un curso.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StudentsManager {
    private static Set<String> students = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("Welcome to Students Course Manager!");

        do {
            showMenu();
            option = getValidOption(scanner);

            switch (option) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine().trim();
                    if (!name.isEmpty()) {
                        addStudent(name);
                    } else {
                        System.out.println("Name cannot be empty!");
                    }
                    break;

                case 2:
                    displayStudentList();
                    break;

                case 3:
                    System.out.print("Enter student name to check: ");
                    String searchName = scanner.nextLine().trim();
                    if (findStudent(searchName)) {
                        System.out.println("Student is enrolled in the course");
                    } else {
                        System.out.println("Student is NOT enrolled in the course");
                    }
                    break;

                case 4:
                    System.out.print("Enter student name to remove: ");
                    String removeName = scanner.nextLine().trim();
                    removeStudent(removeName);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

            if (option != 5) {
                System.out.println();
            }

        } while (option != 5);

        scanner.close();
    }

    private static void addStudent(String name) {
        if (students.add(name)) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Student is already enrolled!");
        }
    }

    private static void removeStudent(String name) {
        if (students.remove(name)) {
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found in the list!");
        }
    }

    private static boolean findStudent(String name) {
        return students.contains(name);
    }

    private static void displayStudentList() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled");
            return;
        }

        System.out.println("Enrolled students:");
        int count = 1;
        for (String student : students) {
            System.out.println(count + ". " + student);
            count++;
        }
        System.out.println("Total: " + students.size() + " students");
    }

    private static void showMenu() {
        System.out.println("=== STUDENTS COURSE MANAGER ===");
        System.out.println("1. Add student");
        System.out.println("2. Show all students");
        System.out.println("3. Check if student is enrolled");
        System.out.println("4. Remove student");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getValidOption(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}