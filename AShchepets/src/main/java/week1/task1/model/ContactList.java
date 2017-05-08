package week1.task1.model;

import week1.task1.utils.ContactUtils;

import java.util.Scanner;

/**
 * Created by SmooZzzie on 09.04.2017.
 */
public class ContactList {

    private final int DEFAULT_CONTACTS_SIZE = 10;

    private Contact[] contactList;
    private int contactSize;
    private int lastElement;


    public ContactList() {
        contactList = new Contact[DEFAULT_CONTACTS_SIZE];
    }

    public ContactList(int contactSize) {

        contactList = new Contact[contactSize];
    }

    public Contact[] getContactList() {
        return contactList;
    }

    public void setContactList(Contact[] contactList) {
        this.contactList = contactList;
    }

    public int getContactSize() {
        return contactSize;
    }

    public void setContactSize(int contactSize) {
        this.contactSize = contactSize;
    }

    public boolean addContact(Contact newContact) {

        if (newContact == null) {
            System.out.println("Please fill in all fields!");
            return false;
        } else {
            if (findContact(newContact) != -1) {
                System.out.println("This contact already exists in your contact list!");
                return false;
            }
        }

        if (lastElement == contactList.length) {
            contactList = ContactUtils.extendContactList(contactList);
            recordingIntoCell(newContact);
            return true;
        } else {
            recordingIntoCell(newContact);
            return true;
        }
    }

    public int findContact(Contact searchingContact) {


        for (int i = 0; i < lastElement; i++) {
            if ((contactList[i].getName()).equals(searchingContact.getName())) {
                return i;
            }
        }

        return -1;
    }

    public void recordingIntoCell(Contact newContact) {
        contactList[lastElement++] = newContact;
    }

    public void removeLastContact() {

        contactList[lastElement--] = null;

    }

    public boolean removeContact(Contact removingContact) {

        int deletingIndex = findContact(removingContact);

        if (removingContact == null) {
            return false;
        }

        if (deletingIndex == -1) {
            return false;
        } else {
            contactList[deletingIndex] = null;
            offsetAfterDeleting(deletingIndex);
            return true;
        }
    }

    public void offsetAfterDeleting(int deletedIndex) {

        for (int i = deletedIndex; i < lastElement - 1; i++) {
            contactList[i] = contactList[i + 1];
            if (i == lastElement - 2) {
                contactList[i + 1] = null;
                lastElement--;
            }
        }

    }

    public void updateContactInfo(Contact updatingContact) {

        Scanner sc = new Scanner(System.in);

        int updatedIndex = findContact(updatingContact);

        if (updatingContact == null) {
            System.out.println("This contact is empty!");
        }

        if (updatedIndex == -1) {
            System.out.println("This contact is not in contact list. Please add it before updating!");
        }

        System.out.println("Select what do you want to update: 1 - name, 2 - phone number, 3 - both");

        int userChoice = sc.nextInt();

        if (userChoice < 1 || userChoice > 3) {
            System.out.println("Please enter only 1-3 numbers!");
            userChoice = sc.nextInt();
        }

        switch (userChoice) {
            case 1:
                updateName(updatedIndex);
            case 2:
                updatePhone(updatedIndex);
            case 3:
                updateName(updatedIndex);
                updatePhone(updatedIndex);
        }

        System.out.println("Done!");

    }

    private void updatePhone(int updatedIndex) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Now enter the phone you want to change for: ");
        String updatingPhone = sc.next();
        contactList[updatedIndex].setPhone(updatingPhone);
        System.out.println("Phone was changed!");
    }

    private void updateName(int updatedIndex) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Now enter the name which you want to change for: ");
        String updatingName = sc.next();
        contactList[updatedIndex].setName(updatingName);
        System.out.println("Name was changed!");
    }


    public void showAllContacts() {

        for (int i = 0; i < lastElement - 1; i++) {
            contactList[i].showContactInfo();
        }

    }

    public void showFirstFiveContacts() {

        if (lastElement < 5) {
            System.out.println("You have only " + lastElement + " in your contact list! Here they are:\n");
            showAllContacts();
        } else {
            System.out.println("Here are your first five contacts:\n");
            for (int i = 0; i < 5; i++) {
                contactList[i].showContactInfo();
            }
        }
    }

    public void showLastFiveContacts() {

        if (lastElement < 5) {
            System.out.println("You have only " + lastElement + " in your contact list! Here they are:\n");
            showAllContacts();
        } else {
            System.out.println("Here are your last five contacts:\n");
            for (int i = lastElement - 1; i > lastElement - 6; i--) {
                contactList[i].showContactInfo();
            }
        }
    }
    
    public void showKyivstarContacts () {

         String[] kyivtarNumbers = {"067","068","097","096","098"};

        for (int i = 0; i < lastElement; i++) {
            for (int j = 0; j < kyivtarNumbers.length; j++) {
                if (contactList[i].getPhone().substring(3,6).equals(kyivtarNumbers[j])) {
                    contactList[i].showContactInfo();
                }
            }

        }
    }

    public void showLifeContacts () {

        String[] lifeNumbers = {"063","093"};

        for (int i = 0; i < lastElement; i++) {
            for (int j = 0; j < lifeNumbers.length; j++) {
                if (contactList[i].getPhone().substring(3,6).equals(lifeNumbers[j])) {
                    contactList[i].showContactInfo();
                }
            }

        }

    }
}
