package week5.day1.overloading;


public class OverloadTest_2 {
    public static void main(String[] args) {
        print((byte) 1);
        print(1);
    }
    public static void print(short n) {
        System.out.println(n);
    }

    public static void print(Integer n) {
        System.out.println(n);
    }
}



