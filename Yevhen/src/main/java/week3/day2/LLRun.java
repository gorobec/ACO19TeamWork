package week3.day2;

import data_structures.MyArrayList;
import data_structures.MyLinkedList;
import data_structures.MyList;

/**
 * Created by gorobec on 23.04.17.
 */
public class LLRun {
    public static void main(String[] args) {
        MyList list = new MyArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);



        for (Object o : list) {
            System.out.println(o);
        }

    }
}
