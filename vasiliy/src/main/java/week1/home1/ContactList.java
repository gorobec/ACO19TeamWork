package week1.home1;

public class ContactList {
    private static final int DEFAULT_COUNT_CONTACTS = 100;

    private Contact[] contacts;
    private int countContacts;

    public ContactList() {
        contacts = new Contact[DEFAULT_COUNT_CONTACTS];
        countContacts = 0;
    }

    public boolean checkPosition(int position) {
        return position >= 0 && position < countContacts;
    }

    public int findContactByName(String contactName) {
        for (int i = 0; i < countContacts; i++) {
            if (contacts[i].getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addContact(Contact contact) {
        if (countContacts == DEFAULT_COUNT_CONTACTS) {
            return false;
        }
        int contactIndex = findContactByName(contact.getName());
        if (contactIndex != -1) {
            return false;
        }
        contacts[countContacts] = contact;
        countContacts++;
        return true;
    }

    public boolean removeLastContact() {
        if (countContacts == 0) {
            return false;
        }
        contacts[countContacts] = null;
        countContacts--;
        return true;
    }

    public Contact getContactByPosition(int position) {
        if (checkPosition(position)) {
            return contacts[position];
        }
        return null;
    }

    public boolean removeContact(int position) {
        if (!checkPosition(position)) {
            return false;
        }
        for (int i = position; i < countContacts; i++) {
            contacts[i] = contacts[i + 1];
        }
        return removeLastContact();
    }

    public boolean updateContact(int position, Contact contact) {
        if (!checkPosition(position)) {
            return false;
        }
        contacts[position] = contact;
        return true;
    }

    public void showAllContacts() {
        showListHeader("All contacts");
        for (int i = 0; i < countContacts; i++) {
            System.out.println(contacts[i].asString());
        }
    }

    private void showListHeader(String header) {
        System.out.println(header);
        System.out.println("--------------------------------");
    }

    public void showFirstFiveContacts() {
        showListHeader("First five contacts");
        for (int i = 0; i < Math.min(countContacts, 5); i++) {
            System.out.println(contacts[i].asString());
        }
    }

    public void showLastFiveContacts() {
        showListHeader("Last five contacts");
        for (int i = countContacts - 1; i >= Math.max(countContacts - 5, 0); i--) {
            System.out.println(contacts[i].asString());
        }
    }

    public void showLifeContacts() {
        showListHeader("Life contacts");
        for (int i = 0; i < countContacts; i++) {
            if (contacts[i].isLife()) {
                System.out.println(contacts[i].asString());
            }
        }
    }

    public void showKievStarContacts() {
        showListHeader("Kiev Star contacts");
        for (int i = 0; i < countContacts; i++) {
            if (contacts[i].isKievStar()) {
                System.out.println(contacts[i].asString());
            }
        }
    }
}