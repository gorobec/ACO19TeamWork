package week3.day2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gorobec on 23.04.17.
 */
public class IteratorTest {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);


        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/

       /* for (Object o : list) {
            System.out.println(o);
        }*/

        Iterator iterator = list.iterator();

        /*while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        Iterator iterator2 = list.iterator();

        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        list.set(2, 7);
        System.out.println(iterator2.next());
        System.out.println(iterator2.next());
        System.out.println(iterator2.next());


    }
}
