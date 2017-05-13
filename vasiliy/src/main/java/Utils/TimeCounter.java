package Utils;

public class TimeCounter {
    public static void countProcessTime(Action action){
        long start = System.currentTimeMillis();

        action.Run();

        long finish = System.currentTimeMillis();

        System.out.printf("Time = %d", finish-start);
    }
}
