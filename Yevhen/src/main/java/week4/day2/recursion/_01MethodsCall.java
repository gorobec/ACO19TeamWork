package week4.day2.recursion;

/**
 * Created by gorobec on 25.12.16.
 */
public class _01MethodsCall {
    public static void main(String[] args) {
        a();
    }

    private static void a() {
        b();
        System.out.println("Inside A");
    }

    private static void b() {
        c();
        System.out.println("Inside B");
    }

    private static void c() {
        System.out.println("Inside C");
    }
}
