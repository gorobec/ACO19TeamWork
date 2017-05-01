package week4.day2.string_problem;

import utils.TimeCounter;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class StringBufferTime {
    public static void main(String[] args) {
        TimeCounter.countProcessTime(() ->
                {
                    StringBuffer buffer = new StringBuffer("");
                    for (int i = 0; i < 50_000_000; i++) {
                        buffer.append(i);
                    }
                    buffer.toString();
                }
        );
    }
}
