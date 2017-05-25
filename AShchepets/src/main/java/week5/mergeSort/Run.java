package week5.mergeSort;

import java.util.Arrays;

/**
 * Created by SmooZzzie on 20.05.2017.
 */
public class Run {

    public static void main(String[] args) {

        Integer[] values = new Integer[]{44,14,87,26,5,31,33,2,42,44,0};

        MergeSorting.sort(values);
        System.out.println(Arrays.toString(values));
    }
}
