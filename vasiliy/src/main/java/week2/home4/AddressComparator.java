package week2.home4;

import java.util.Comparator;

public class AddressComparator implements Comparator<Reader> {
    @Override
    public int compare(Reader r1, Reader r2) {
        return r1.getAddress().compareTo(r2.getAddress());
    }
}
