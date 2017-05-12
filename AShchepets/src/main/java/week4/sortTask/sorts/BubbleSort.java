package week4.sortTask.sorts;

/**
 * Created by SmooZzzie on 10.05.2017.
 */
public class BubbleSort<T> {

    public static <T extends Comparable> void sortByBubble(T[] array) {

        T[] sortingArray = array;

        boolean swapped;
        T tempValue;

        do {
            swapped = false;
            for (int i = 0; i < array.length-1; i++) {


                if (array[i].compareTo(array[i+1]) > 0) {

                    tempValue = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tempValue;

                    swapped = true;
                }
            }
        } while (swapped);
    }


}
