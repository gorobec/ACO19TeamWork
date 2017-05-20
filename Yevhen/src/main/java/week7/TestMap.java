package week7;

import data_structures.MyHashMap;
import data_structures.MyMap;

/**
 * Created by gorobec on 20.05.17.
 */
public class TestMap {
    public static void main(String[] args) {
        MyMap<Integer, String> map = new MyHashMap<>(10, 0.3f);

        System.out.println(map.size());

        System.out.println(map.put(1, "one"));
        System.out.println(map.put(1, "one"));
        System.out.println(map.put(11, "eleven"));
        System.out.println(map.put(2, "two"));
        System.out.println(map.put(2, "two"));
        System.out.println(map.put(3, "three"));
        System.out.println(map.put(4, "four"));

        System.out.println(map.size());

    }
}
