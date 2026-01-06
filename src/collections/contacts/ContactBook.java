package collections.contacts;

/*
Agenda de contactos implementada con HashMap.
Permite añadir, buscar, eliminar y mostrar contactos.
 */

import java.util.HashMap;
import java.util.Map;

class ContactBook {
    private Map<String, String> contacts;

    public ContactBook() {
        this.contacts = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        contacts.put(name, phone);
    }

    public boolean removeContact(String name) {
        return contacts.remove(name) != null;
    }

    public String findContact(String name) {
        String phone = contacts.get(name);
        return phone != null ? "Phone: " + phone : "Contact not found";
    }

    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found");
            return;
        }

        System.out.println("All contacts:");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println("Name: " + entry.getKey() + " - Phone: " + entry.getValue());
        }
    }
}