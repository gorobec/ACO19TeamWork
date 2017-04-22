package week1.contact_catalog;

/**
 * @author Ivan Knyazev on 18.04.2017
 * @since JDK 1.8
 */
public class TestContactList {
    public static void main(String[] args) {

        ContactList contactList = new ContactList();


        Contact contact = new Contact("Ivan", "+380678252255");

        Contact contact1 = new Contact("Ivan", "+38067825228y");

        Contact contact2 = new Contact("", "+380678252287");

        contactList.addContact(contact);
        contactList.addContact(contact1);
        contactList.addContact(contact2);

        contactList.showAllContacts();

        contactList.removeLast();


    }
}
