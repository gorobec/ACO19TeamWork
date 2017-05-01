package week4.day2.recursion;

/**
 * Created by gorobec on 25.12.16.
 */
public class _02RecursionIntro {
    public static void main(String[] args) {
        a();
    }

    private static void a() {
        System.out.println("Inside A");
        a();
    }
}
