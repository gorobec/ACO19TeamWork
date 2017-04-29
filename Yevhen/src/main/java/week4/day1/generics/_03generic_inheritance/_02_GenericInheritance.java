package week4.day1.generics._03generic_inheritance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class _02_GenericInheritance {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

//        print(strings);  // -?
//        print(objects);  // -?
    }

    public static void print(Collection<String> list){
        for (String string : list) {
            System.out.println(string);
        }
    }
}
