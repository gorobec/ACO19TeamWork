package week4.day1.generics._01_raw_type_wirh_generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class RawType {
    public static void main(String[] args) {


        List rawType = new ArrayList<>();
        List<String> list = new ArrayList<>();

       /* rawType = list;
        list = rawType;*/

        rawType.add(1);

        rawType.add("2");

        String s = list.get(0);

        System.out.println(s);

    }
}
