package week4.day1.generics._02_generic_life_cycle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class TestLifecycle {
    public static void main(String[] args) {
//        LifecycleOfGenerics lc = new LifecycleOfGenerics();
        LifecycleOfGenerics<Object> lc = new LifecycleOfGenerics<>();

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        lc.show(list);
    }

}
