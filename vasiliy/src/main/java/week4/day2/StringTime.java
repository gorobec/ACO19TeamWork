package week4.day2;

import Utils.Action;
import Utils.TimeCounter;

public class StringTime {
    public static void main(String[] args) {
        /*Action action = new StringAction();
        TimeCounter.countProcessTime(action);

        TimeCounter.countProcessTime(new StringAction());

        TimeCounter.countProcessTime(new Action() {
            @Override
            public void Run() {
                String s = "";
                for (int i = 0; i < 10_000; i++) {
                    s+=i;
                }
            }
        });*/

        TimeCounter.countProcessTime(() -> {
            String s = "";
            for (int i = 0; i < 100_000; i++) {
                s+=i;
            }
        });

    }
}
