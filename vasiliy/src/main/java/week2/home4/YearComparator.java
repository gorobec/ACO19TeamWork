package week2.home4;

import java.util.Comparator;

public class YearComparator implements Comparator<Edition> {
    @Override
    public int compare(Edition e1, Edition e2) {
        return e1.getYear() - e2.getYear();
    }
}
