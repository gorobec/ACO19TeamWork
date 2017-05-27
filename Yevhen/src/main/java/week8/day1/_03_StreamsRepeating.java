package week8.day1;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by gorobec on 27.05.17.
 */
public class _03_StreamsRepeating {
    public static void main(String[] args) {

        /*Stream<String> stream =
                Stream.of("dd2", "aa2", "bb1", "bb3", "cc")
                        .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);    // Successful
        stream.noneMatch(s -> true);   // Exception*/


        /*Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("dd2", "aa2", "bb1", "bb3", "cc")
                        .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);   // Successful
        streamSupplier.get().noneMatch(s -> true);  // Also ok*/


    }
}
