package howeWorkWeek4.task4_2;

/**
 * Created by volodymyrkorniienko on 09.05.17.
 */
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        int temp;

        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] > array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
            System.out.print(array[i] + " ");
        }
    }
}
