package week3.day1;

import java.util.Arrays;

/**
 * Created by SmooZzzie on 29.04.2017.
 */
public class BinarySearch {

    private Comparable[] array;
    private Comparable searchingObject;

    public BinarySearch(Comparable[] array, Comparable searchingObject) {
        this.array = array;
        this.searchingObject = searchingObject;
    }

    static boolean contains(Comparable[] array, Comparable o) {

        int start = 0;
        int end = array.length - 1;
        int middle;

        Arrays.sort(array);

        while (start != end) {
            middle = (start + end) / 2;
            int result = o.compareTo(array[middle]);
            if (result == 0) {
                return true;
            } else if (result > 0) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return false;
    }
}
