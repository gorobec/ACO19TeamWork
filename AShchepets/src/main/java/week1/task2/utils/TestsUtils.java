package week1.task2.utils;

/**
 * Created by SmooZzzie on 08.04.2017.
 */
public class TestsUtils {

    public static void showTestResult(String nameOfTestingMethod, boolean resultOfTesting) {

        System.out.println(String.format("***Result of testing %s(): %b", nameOfTestingMethod, resultOfTesting));

    }
}
