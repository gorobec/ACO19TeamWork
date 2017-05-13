package week4.day2;

import Utils.Action;

public class StringAction implements Action {
    @Override
    public void Run() {
        String s = "";
        for (int i = 0; i < 10_000; i++) {
            s+=i;
        }
    }
}
