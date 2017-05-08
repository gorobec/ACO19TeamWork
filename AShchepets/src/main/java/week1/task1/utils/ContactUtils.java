package week1.task1.utils;

import week1.task1.model.Contact;

/**
 * Created by SmooZzzie on 10.04.2017.
 */
public class ContactUtils {


    public static Contact[] extendContactList(Contact[] contactList) {

        Contact[] extendedContainer = new Contact[contactList.length * 2];

        for (int i = 0; i < contactList.length; i++) {
            extendedContainer[i] = contactList[i];
        }

        return extendedContainer;
    }

}
