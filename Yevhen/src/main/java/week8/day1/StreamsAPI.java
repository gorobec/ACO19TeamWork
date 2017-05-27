package week8.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by gorobec on 27.05.17.
 */
public class StreamsAPI {
    public static void main(String[] args) {
        List<String> mList = Arrays.asList("aa2","cc2", "cc1", "aa1", "bb1");

        /*List<String> withA = new ArrayList<>();
        for (String s : mList) {
            if(s.startsWith("a")){
                s = s.toUpperCase();
                withA.add(s);
            }
        }
        Object[] array = withA.toArray();
        Arrays.sort(array);
        for (Object s : array) {
            System.out.println(s);
        }*/

        /*mList
                .stream()
                .filter(s -> s.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);*/





        /*Arrays.asList("сс1", "сс2", "сс3")
                .stream()
                .findFirst()
                .ifPresent(System.out::println);*/





       /* Stream.of("сс1", "сс2", "сс3")
                .findFirst()
                .ifPresent(System.out::println);*/



        /*IntStream.range(8, 12)
                .forEach(System.out::println);*/



/*
        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);
*/



        /*Stream.of("c1", "c2", "c3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);*/


       /* IntStream.range(1, 4)
                .mapToObj(i -> "с" + i)
                .forEach(System.out::println);*/


       /* Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "с" + i)
                .forEach(System.out::println);*/



    }
}
