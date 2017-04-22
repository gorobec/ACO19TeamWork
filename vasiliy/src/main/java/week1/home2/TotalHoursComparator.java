package week1.home2;

import java.util.Comparator;

public class TotalHoursComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Subject subject1 = (Subject) o1;
        Subject subject2 = (Subject) o2;
        return subject1.getSubjectInfo().getTotalHours()-subject2.getSubjectInfo().getTotalHours();
    }
}
