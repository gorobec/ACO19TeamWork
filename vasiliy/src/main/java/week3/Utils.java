package week3;

import java.util.List;

public class Utils {
    public static <T extends Product> boolean find(List<T> products, T product){
        return products.contains(product);
    }

    public static<T> void copy(List<? extends T> src, List<? super T> dest){
        for (T product : src) {
            dest.add(product);
        }
    }
}
