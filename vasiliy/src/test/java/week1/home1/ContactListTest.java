package week1.home1;

import org.junit.Assert;
import org.junit.Test;

public class ContactListTest {

    @Test
    public void checkPosition1() {
        ContactList contactList = new ContactList();
        Contact contact1 = new Contact();
        contact1.init("Name1", "0631234567");
        contactList.addContact(contact1);
        Contact contact2 = new Contact();
        contact2.init("Name2", "0501234567");
        contactList.addContact(contact2);
        Contact contact3 = new Contact();
        contact3.init("Name3", "0981234567");
        contactList.addContact(contact3);

        boolean expected = false;
        boolean actual = contactList.checkPosition(-1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPosition2() {
        ContactList contactList = new ContactList();
        Contact contact1 = new Contact();
        contact1.init("Name1", "0631234567");
        contactList.addContact(contact1);
        Contact contact2 = new Contact();
        contact2.init("Name2", "0501234567");
        contactList.addContact(contact2);
        Contact contact3 = new Contact();
        contact3.init("Name3", "0981234567");
        contactList.addContact(contact3);

        boolean expected = false;
        boolean actual = contactList.checkPosition(3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPosition3() {
        ContactList contactList = new ContactList();
        Contact contact1 = new Contact();
        contact1.init("Name1", "0631234567");
        contactList.addContact(contact1);
        Contact contact2 = new Contact();
        contact2.init("Name2", "0501234567");
        contactList.addContact(contact2);
        Contact contact3 = new Contact();
        contact3.init("Name3", "0981234567");
        contactList.addContact(contact3);

        boolean expected = true;
        boolean actual = contactList.checkPosition(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findContactByName1() {
        ContactList contactList = new ContactList();
        Contact contact = new Contact();
        contact.init("Name1", "0631234567");
        contactList.addContact(contact);

        int expected = 0;
        int actual = contactList.findContactByName("Name1");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findContactByName2() {
        ContactList contactList = new ContactList();
        Contact contact = new Contact();
        contact.init("Name1", "0631234567");
        contactList.addContact(contact);

        int expected = -1;
        int actual = contactList.findContactByName("Name2");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addContact1() {
        ContactList contactList = new ContactList();
        Contact contact = new Contact();
        contact.init("Name1", "0631234567");

        boolean expected = true;
        boolean actual = contactList.addContact(contact);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addContact2() {
        ContactList contactList = new ContactList();
        Contact contact = new Contact();
        contact.init("Name1", "0631234567");
        contactList.addContact(contact);

        boolean expected = false;
        boolean actual = contactList.addContact(contact);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeLastContact1() {
        ContactList contactList = new ContactList();
        Contact contact = new Contact();
        contact.init("Name1", "0631234567");
        contactList.addContact(contact);

        boolean expected = true;
        boolean actual = contactList.removeLastContact();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeLastContact2() {
        ContactList contactList = new ContactList();

        boolean expected = false;
        boolean actual = contactList.removeLastContact();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getContactByPosition1() {
        ContactList contactList = new ContactList();
        Contact contact1 = new Contact();
        contact1.init("Name1", "0631234567");
        contactList.addContact(contact1);
        Contact contact2 = new Contact();
        contact2.init("Name2", "0501234567");
        contactList.addContact(contact2);
        Contact contact3 = new Contact();
        contact3.init("Name3", "0981234567");
        contactList.addContact(contact3);

        Contact expected = null;
        Contact actual = contactList.getContactByPosition(-1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getContactByPosition2() {
        ContactList contactList = new ContactList();
        Contact contact1 = new Contact();
        contact1.init("Name1", "0631234567");
        contactList.addContact(contact1);
        Contact contact2 = new Contact();
        contact2.init("Name2", "0501234567");
        contactList.addContact(contact2);
        Contact contact3 = new Contact();
        contact3.init("Name3", "0981234567");
        contactList.addContact(contact3);

        Contact expected = contact2;
        Contact actual = contactList.getContactByPosition(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getContactByPosition3() {
        ContactList contactList = new ContactList();
        Contact contact1 = new Contact();
        contact1.init("Name1", "0631234567");
        contactList.addContact(contact1);
        Contact contact2 = new Contact();
        contact2.init("Name2", "0501234567");
        contactList.addContact(contact2);
        Contact contact3 = new Contact();
        contact3.init("Name3", "0981234567");
        contactList.addContact(contact3);

        Contact expected = null;
        Contact actual = contactList.getContactByPosition(3);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeContact1() {
        ContactList contactList = new ContactList();
        Contact contact = new Contact();
        contact.init("Name1", "0631234567");
        contactList.addContact(contact);

        boolean expected = true;
        boolean actual = contactList.removeContact(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeContact2() {
        ContactList contactList = new ContactList();
        Contact contact1 = new Contact();
        contact1.init("Name1", "0631234567");
        contactList.addContact(contact1);
        Contact contact2 = new Contact();
        contact2.init("Name2", "0501234567");
        contactList.addContact(contact2);
        Contact contact3 = new Contact();
        contact3.init("Name3", "0981234567");
        contactList.addContact(contact3);

        boolean expected = true;
        boolean actual = contactList.removeContact(1);
        Assert.assertEquals(expected, actual);
        Contact expectedContact = contact3;
        Contact actualContact = contactList.getContactByPosition(1);
        Assert.assertEquals(expectedContact, actualContact);
    }

    @Test
    public void updateContact() {
        ContactList contactList = new ContactList();
        Contact contact1 = new Contact();
        contact1.init("Name1", "0631234567");
        contactList.addContact(contact1);
        Contact contact2 = new Contact();
        contact2.init("Name2", "0501234567");

        boolean expected = true;
        boolean actual = contactList.updateContact(0, contact2);
        Assert.assertEquals(expected, actual);
        Contact expectedContact = contact2;
        Contact actualContact = contactList.getContactByPosition(0);
        Assert.assertEquals(expectedContact, actualContact);
    }
}