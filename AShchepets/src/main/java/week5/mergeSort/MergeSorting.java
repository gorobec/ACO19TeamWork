package week5.mergeSort;

/**
 * Created by SmooZzzie on 20.05.2017.
 */
public class MergeSorting<T> {

    public static <E extends Comparable<? super E>> void sort(E[] a) {
        mergeSort(a, 0, a.length - 1);
    }


    private static <E extends Comparable<? super E>> void mergeSort(E[] a, int from, int to) {
        if (from == to)
            return;
        int mid = (from + to) / 2;
        // Sort the first and the second half
        mergeSort(a, from, mid);
        mergeSort(a, mid + 1, to);
        merge(a, from, mid, to);
    }

    private static <E extends Comparable<? super E>> void merge(E[] a, int from, int mid, int to) {
        int n = to - from + 1;
        Object[] values = new Object[n];

        int fromValue = from;

        int middleValue = mid + 1;

        int index = 0;

        while (fromValue <= mid && middleValue <= to) {
            if (a[fromValue].compareTo(a[middleValue]) < 0) {
                values[index] = a[fromValue];
                fromValue++;
            } else {
                values[index] = a[middleValue];
                middleValue++;
            }
            index++;
        }

        while (fromValue <= mid) {
            values[index] = a[fromValue];
            fromValue++;
            index++;
        }
        while (middleValue <= to) {
            values[index] = a[middleValue];
            middleValue++;
            index++;
        }

        for (index = 0; index < n; index++)
            a[from + index] = (E) values[index];
    }

}
