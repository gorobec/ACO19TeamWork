package week5.day1.exception;

import data_structures.MyArrayList;
import data_structures.MyList;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class TestALException {
    public static void main(String[] args) {
        MyList<Integer> integers = new MyArrayList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        integers.remove(5);
    }
}
