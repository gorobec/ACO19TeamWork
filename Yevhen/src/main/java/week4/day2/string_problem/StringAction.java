package week4.day2.string_problem;

import utils.Action;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class StringAction implements Action {
    @Override
    public void run() {
        String s = "";
        for (int i = 0; i < 10_000; i++) {
            s += i;
        }
    }
}
