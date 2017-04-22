package week1.home1;

import java.util.Scanner;

public class ContactListMenu {
    private Scanner scanner = new Scanner(System.in);
    private ContactList contactList;

    private int readPosition() {
        System.out.println("Input position:");
        int position = scanner.nextInt();
        if (!contactList.checkPosition(position)) {
            System.out.println("There is no contact with such position.");
            return -1;
        }
        return position;
    }

    private Contact readContact() {
        System.out.println("Input name:");
        String name = scanner.next();
        System.out.println("Input phone:");
        String phone = scanner.next();
        Contact contact = new Contact();
        if (contact.init(name, phone)) {
            return contact;
        }
        System.out.println("Invalid data");
        return null;
    }

    public void start(ContactList contactList) {
        this.contactList = contactList;

        while (true) {
            showMainMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case 0: {
                    return;
                }
                case 1: {
                    showAddContactMenu();
                    break;
                }
                case 2: {
                    removeLastContact();
                    break;
                }
                case 3: {
                    showFindContactMenu();
                    break;
                }
                case 4: {
                    removeContactMenu();
                    break;
                }
                case 5: {
                    updateContactMenu();
                    break;
                }
                case 6: {
                    showAllContacts();
                    break;
                }
                case 7: {
                    showFirstFiveContacts();
                    break;
                }
                case 8: {
                    showLastFiveContacts();
                    break;
                }
                case 9: {
                    showLifeContacts();
                    break;
                }
                case 10: {
                    showKievStarContacts();
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                    showMainMenu();
                    break;
                }
            }
        }
    }

    private void removeLastContact() {
        if (contactList.removeLastContact()) {
            System.out.println("Last contact was removed successfully.");
        } else {
            System.out.println("Error: Contact list is empty.");
        }
    }

    private void showKievStarContacts() {
        contactList.showKievStarContacts();
    }

    private void showLifeContacts() {
        contactList.showLifeContacts();
    }

    private void showLastFiveContacts() {
        contactList.showLastFiveContacts();
    }

    private void showFirstFiveContacts() {
        contactList.showFirstFiveContacts();
    }

    private void showAllContacts() {
        contactList.showAllContacts();
    }

    private void updateContactMenu() {
        int position = readPosition();
        if (position == -1) {
            return;
        }
        Contact contact = readContact();
        if (contact == null) {
            return;
        }
        if (contactList.updateContact(position, contact)) {
            System.out.println("Contact was updated successfully.");
        }
    }

    private void removeContactMenu() {
        int position = readPosition();
        if (position == -1) {
            return;
        }
        if (contactList.removeContact(position)) {
            System.out.println("Contact was removed successfully.");
        }
    }

    private void showFindContactMenu() {
        System.out.println("Input name:");
        String name = scanner.next();
        int position = contactList.findContactByName(name);
        if (position == -1) {
            System.out.println("There is no contact with such name.");
        } else {
            Contact contact = contactList.getContactByPosition(position);
            System.out.println(contact.asString());
        }
    }

    private void showAddContactMenu() {
        Contact contact = readContact();
        if (contact != null) {
            if (contactList.addContact(contact)) {
                System.out.println("Contact was added successfully.");
            } else {
                System.out.println("There exists contact with the same name.");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("1. Add contact");
        System.out.println("2. Remove last contact");
        System.out.println("3. Find contact");
        System.out.println("4. Remove contact");
        System.out.println("5. Update contact info");
        System.out.println("6. Show all contacts");
        System.out.println("7. Show first five contacts");
        System.out.println("8. Show last five contacts");
        System.out.println("9. Show Life contacts");
        System.out.println("10. Show Kiev Star contacts");
        System.out.println("0. Exit");
    }
}