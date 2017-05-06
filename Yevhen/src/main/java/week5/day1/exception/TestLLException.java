package week5.day1.exception;

import data_structures.MyLinkedList;
import data_structures.MyList;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class TestLLException {
    public static void main(String[] args) {
        MyList<String> strings = new MyLinkedList<>();

        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");

        strings.remove(4);
    }
}
