package week1.task2.utils;

import week1.task2.model.Subject;

/**
 * Created by SmooZzzie on 06.04.2017.
 */
public class CommonUtils {


    public static Subject[] extendContainer(Subject[] containerOfSubjects) {

        Subject[] extendedContainer = new Subject[containerOfSubjects.length * 2];

        for (int i = 0; i < containerOfSubjects.length; i++) {
            extendedContainer[i] = containerOfSubjects[i];
        }

        return extendedContainer;
    }

}
