package week4.sortTask.sorts;


/**
 * Created by SmooZzzie on 10.05.2017.
 */
public class InsertionSort<T> {

    public static <T extends Comparable> void sortByInsertion(T[] array) {

        T temp;
        int j;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                temp = array[i + 1];
                array[i + 1] = array[i];
                j = i;
                while (j > 0 && temp.compareTo(array[j - 1]) < 0) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;

            }
        }
    }
}
