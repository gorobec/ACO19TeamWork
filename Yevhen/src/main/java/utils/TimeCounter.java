package utils;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class TimeCounter {

    public static void countProcessTime(Action action){

        long startTime = System.currentTimeMillis();
        action.run();
        long finishTime = System.currentTimeMillis();
        System.out.printf("Time = %d", finishTime - startTime);

    }
}
