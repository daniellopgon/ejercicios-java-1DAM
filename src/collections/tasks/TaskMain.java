

package collections.tasks;

import java.util.Scanner;

public class TaskMain {
    public static void main(String[] args) {
        collections.tasks.TaskList taskList = new collections.tasks.TaskList();
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println("Welcome to Task Manager!");

        do {
            showMenu();
            option = getValidOption(scanner);

            switch (option) {
                case 1:
                    System.out.print("Enter new task: ");
                    String newTask = scanner.nextLine();
                    taskList.addTask(newTask);
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    if (taskList.isEmpty()) {
                        System.out.println("No tasks to complete!");
                        break;
                    }
                    taskList.displayTasks();
                    System.out.print("Enter task to mark as completed: ");
                    String completedTask = scanner.nextLine();
                    if (taskList.removeTask(completedTask)) {
                        System.out.println("Task completed and removed!");
                    } else {
                        System.out.println("Task not found!");
                    }
                    break;

                case 3:
                    taskList.displayTasks();
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

            if (option != 4) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }

        } while (option != 4);

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n=== TASK MANAGER MENU ===");
        System.out.println("1. Add new task");
        System.out.println("2. Mark task as completed (remove)");
        System.out.println("3. View pending tasks");
        System.out.println("4. Exit");
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