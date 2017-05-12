package week4.binarySearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by SmooZzzie on 29.04.2017.
 */
public class BinarySearch {

    public static <T extends Comparable<? super T>> boolean contains(T[] array, T o) {

        return contains(array, o, null);
    }

    public static <T extends Comparable<? super T>> boolean contains(T[] array, T o, Comparator<T> comparator) {

        if(o == null) throw new NullPointerException("Method not support null search: o == null");

        int start = 0;
        int end = array.length - 1;
        int middle;

        Arrays.sort(array, comparator);

        while (end >= start) {

            middle = (start + end) / 2;

            int result = comparator != null ?
                    comparator.compare(o, array[middle]) :
                    o.compareTo(array[middle]);

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
