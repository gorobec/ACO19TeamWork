package week4.day2;

import Utils.TimeCounter;

public class StringBuilderTime {
    public static void main(String[] args) {
        TimeCounter.countProcessTime(()->{
            StringBuilder builder = new StringBuilder("");
            for (int i = 0; i <10_000_000 ; i++) {
                builder.append(i);
            }
            builder.toString();
        });
    }
}
