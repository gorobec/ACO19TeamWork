package week1.home1;

public class RunContactListMenu {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        ContactListMenu menu = new ContactListMenu();
        menu.start(contactList);
    }
}