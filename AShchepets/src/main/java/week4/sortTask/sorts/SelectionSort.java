package week4.sortTask.sorts;

/**
 * Created by SmooZzzie on 10.05.2017.
 */
public class SelectionSort<T> {

    public static <T extends Comparable> void sortBySelection(T[] array) {

        for (int min = 0; min < array.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < array.length; j++) {
                if (array[j].compareTo(array[least]) <0) {
                    least = j;
                }
            }
            T tmp = array[min];
            array[min] = array[least];
            array[least] = tmp;
        }
    }
}
