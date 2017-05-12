package week4.sortTask.Runer;

import week4.sortTask.sorts.BubbleSort;

/**
 * Created by SmooZzzie on 10.05.2017.
 */
public class RunBubbleSort {
    public static void main(String[] args) {
        Integer[] testArray = new Integer[]{22, 1, 55, 396, 33, 0, 25};

        showArray(testArray);
        BubbleSort.sortByBubble(testArray);
        showArray(testArray);

        String[] testArray2 = {"qw","qw17654","test11","test500","artem","vova"};

        showArray(testArray2);
        BubbleSort.sortByBubble(testArray2);
        showArray(testArray2);
    }
    static<T> void showArray(T[] testArray) {
        System.out.println();
        for (int i = 0; i < testArray.length; i++) {
            System.out.print(" " + testArray[i]);
        }
    }
}
