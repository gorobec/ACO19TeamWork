package week1.contact_catalog;

/**
 * @author Ivan Knyazev on 18.04.2017
 * @since JDK 1.8
 */
public class ContactList {

    private static final int SIZE_CONTACTLIST = 10;
    private Contact[] contacts = new Contact[SIZE_CONTACTLIST];
    private int size = 0;
    private int count = 1;

    public boolean addContact(Contact contact) {
        if (contact.getName() == null || contact.getPhone() == null) return false;
        if (size >= SIZE_CONTACTLIST) return false;
        contacts[size++] = contact;
        return true;
    }

    public String asString(){
        String result = "CONTACT LIST\nAll Contacts\n";
        for (int i = 0; i < size; i++) {
            Contact currContact = contacts[i];
            result += "\t" + count++ +".  " + currContact.asString() + "\n";
        }
        return result;
    }

    public void showAllContacts (){
        System.out.println(asString());
    }

    public boolean removeLast() {
        if (size == 0) return false;
        if (size == SIZE_CONTACTLIST + 1) return false;
        contacts[size] = null;
        size--;
        return true;
    }
}
