package week2.task5_7Equals_Comparable;

import java.util.Comparator;

/**
 * Created by SmooZzzie on 11.05.2017.
 */
public class StudentComparator implements Comparator<Student>{


    @Override
    public int compare(Student o1, Student o2) {

        return o1.compareTo(o2);
    }
}
