package week4.day2.string_problem;

import utils.Action;
import utils.TimeCounter;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class StringTime {
    public static void main(String[] args) {

//        1st
   /*     Action action = new StringAction();
        TimeCounter.countProcessTime(action);*/


//        2nd
//        TimeCounter.countProcessTime(new StringAction());


//        3rd
       /* TimeCounter.countProcessTime(new Action() {
            @Override
            public void run() {
                String s = "";
                for (int i = 0; i < 10_000; i++) {
                    s += i;
                }
            }
        }); */

//        4th
        TimeCounter.countProcessTime(() ->
                {
                    String s = "";
                    for (int i = 0; i < 1000_000; i++) {
                        s += i;
                    }
                }
        );





    }
}
