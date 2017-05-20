package week7;

import week2.day1.Employee;
import week2.day1.Middle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by gorobec on 20.05.17.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Integer, Employee> map = new HashMap<>();

        System.out.println("Size " + map.size());

        System.out.println(map.put(1, new Middle("Jack", "Smith", 20, "Java")));
        System.out.println(map.put(12, new Middle("Jack", "Smith", 20, "Java")));
        System.out.println(map.put(17, new Middle("Jack", "Smith", 20, "Java")));
//        System.out.println(map.put(12, new Middle("Jack2", "Smith", 20, "Java")));

        Iterator <Map.Entry<Integer, Employee>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry<Integer, Employee> entry = iterator.next();
            System.out.printf("Key - %d, valure - %s\n", entry.getKey(), entry.getValue());
        }

        Iterator <Integer> keyIterator = map.keySet().iterator();

        while (keyIterator.hasNext()){
            Integer key = keyIterator.next();
            System.out.printf("Key - %d, valure - %s\n", key, map.get(key));
        }

    }
}
