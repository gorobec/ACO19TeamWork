package howeWorkWeek4.task4_2;

/**
 * Created by volodymyrkorniienko on 09.05.17.
 */
public class SelectionSort {

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;

            System.out.println(array[i]);
        }
    }
}
