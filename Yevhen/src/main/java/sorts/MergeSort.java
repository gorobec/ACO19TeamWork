package sorts;


public class MergeSort {


    public static void sort(int[] array){
//        create work space for copying
        int[] workSpace = new int[array.length];
//        start recursion sort
        recSort(array, workSpace, 0, array.length - 1);
    }

    private static void recSort(int[] array, int[] workSpace, int lowerBound, int upperBound){
//          only one element (sort doesn't needed)
        if (lowerBound == upperBound) return;
//          the middle of array
        int middle = (lowerBound + upperBound) / 2;
//          sort first part
        recSort(array, workSpace, lowerBound, middle);
//          sort second part
        recSort(array, workSpace, middle + 1, upperBound);
//          merge two parts
        merge(array, workSpace, lowerBound, middle + 1, upperBound);

    }

    private static void merge(int[] array, int[] workSpace, int firstStart, int secondStart, int upperBound) {
//        workSpace index
        int idx = 0;
        int lowerBound = firstStart;
        int middle = secondStart - 1;
//        elements amount
        int elements = upperBound - lowerBound + 1;
//        both parts have not copied elements
        while (firstStart <= middle && secondStart <= upperBound){
            if(array[firstStart] < array[secondStart])
                workSpace[idx++] = array[firstStart++];
            else
                workSpace[idx++] = array[secondStart++];
        }
//        second part is empty
        while (firstStart <= middle){
            workSpace[idx++] = array[firstStart++];
        }
//        first part is empty
        while (secondStart <= upperBound){
            workSpace[idx++] = array[secondStart++];
        }
//        write sorted elements from workSpace to array
        System.arraycopy(workSpace, 0, array, lowerBound, elements);
    }
}
