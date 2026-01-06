package collections.contacts;

/*
Clase principal para ejecutar la aplicación de agenda de contactos.
 */

import java.util.Scanner;

public class ContactBookMain {

    public static void main(String[] args) {
        ContactBook contacts = new ContactBook();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Contact Book Application");

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    contacts.addContact(name, phone);
                    System.out.println("Contact added successfully!");
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    String result = contacts.findContact(searchName);
                    System.out.println(result);
                    break;

                case 3:
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    if (contacts.removeContact(deleteName)) {
                        System.out.println("Contact deleted successfully!");
                    } else {
                        System.out.println("Contact not found!");
                    }
                    break;

                case 4:
                    contacts.displayAllContacts();
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

            System.out.println();
        }
    }

    private static void showMenu() {
        System.out.println("--- Contact Book Menu ---");
        System.out.println("1. Add contact");
        System.out.println("2. Search contact");
        System.out.println("3. Delete contact");
        System.out.println("4. Show all contacts");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }
}