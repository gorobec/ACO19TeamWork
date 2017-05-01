package week4.day2.string_problem;

import utils.TimeCounter;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class StringBuilderTime {
    public static void main(String[] args) {
        TimeCounter.countProcessTime(() ->
                {
                    StringBuilder builder = new StringBuilder("");
                    for (int i = 0; i < 50_000_000; i++) {
                        builder.append(i);
                    }
                    builder.toString();
                }
        );
    }
}
