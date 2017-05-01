package week5.day1.overloading;


public class OverloadTest_1 {

    public static void main(String[] args) {


        print(1);
        print((byte) 1);
        print("1");
//        print(null);

    }

    public static void print(long n) {
        System.out.println(n);
    }

    public static void print(short n) {
        System.out.println(n);
    }

    public static void print(Integer n) {
        System.out.println(n);
    }

    public static void print(String s) {
        System.out.println(s);
    }

}