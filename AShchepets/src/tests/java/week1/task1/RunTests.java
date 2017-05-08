package week1.task1;

import week1.task1.model.Contact;
import week1.task1.model.ContactList;

/**
 * Created by SmooZzzie on 09.04.2017.
 */
public class RunTests {

    public static void main(String[] args) {

        ContactList testContactList = new ContactList(5);

        Contact testContact1 = new Contact("testName1","+380672830076");
        Contact testContact2 = new Contact("testName2","+380662830176");
        Contact testContact3 = new Contact("testName3","+380932830276");
        Contact testContact4 = new Contact("testName4","+380632830376");

        testContactList.addContact(testContact1);
        testContactList.addContact(testContact2);
        testContactList.addContact(testContact3);
        testContactList.addContact(testContact4);


    /*    testContactList.removeLastContact();

        testContactList.findContact(testContact3);
        testContactList.removeContact(testContact1);

      testContactList.updateContactInfo(testContact2);

        testContactList.showAllContacts();

        testContactList.showFirstFiveContacts();
        testContactList.showLastFiveContacts();*/

        testContactList.showKyivstarContacts();
        testContactList.showLifeContacts();
    }

}
