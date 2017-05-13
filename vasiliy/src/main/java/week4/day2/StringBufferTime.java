package week4.day2;

import Utils.TimeCounter;

public class StringBufferTime {
    public static void main(String[] args) {
        TimeCounter.countProcessTime(()->{
            StringBuffer buffer = new StringBuffer("");
            for (int i = 0; i <10_000_000 ; i++) {
                buffer.append(i);
            }
            buffer.toString();
        });
    }
}
