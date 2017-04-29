package week4.day1.generics._02_generic_life_cycle;

import java.util.Collection;
import java.util.List;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class LifecycleOfGenerics<T> {

    public <E> void show(Collection<E> collection){
        for (E t : collection) {
            System.out.println(t);
        }
    }

    public void show(List<Integer> list){
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
