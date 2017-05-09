package howeWorkWeek4.task4_2;

/**
 * Created by volodymyrkorniienko on 09.05.17.
 */
public class InsertSort {
    
    public static void insertSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println(array[i]);
        }
    }
}
