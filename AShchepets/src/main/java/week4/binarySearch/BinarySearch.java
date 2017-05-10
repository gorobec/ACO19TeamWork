package week4.binarySearch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by SmooZzzie on 29.04.2017.
 */
public class BinarySearch {

    public static<T extends Comparable> boolean contains(Comparable<T>[] array, Comparable<T> o) {

        int start = 0;
        int end = array.length - 1;
        int middle;

        Arrays.sort(array);

        while (start != end) {

            middle = (start + end) / 2;

            // без кастирования в Т выдавало ошибку компиляции
            // Это из-за того,что метод Array.sort() работает с входящими данными
            // как с объектами и кастирует их внутри своего метода.
            // Приходится обратно кастировать с объекта в Т после сортировки

            int result = o.compareTo((T) array[middle]);
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

    public static<T extends Comparator> boolean contains(T[] array, T o, Comparator<? super T> comparator ) {

        int start = 0;
        int end = array.length - 1;
        int middle;

        Arrays.sort(array,comparator);

        while (start != end) {

            middle = (start + end) / 2;

            int result = comparator.compare(o, array[middle]);

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
