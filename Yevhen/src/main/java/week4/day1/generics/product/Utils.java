package week4.day1.generics.product;

import java.util.List;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Utils {

    public static boolean find(List<Product> products, Product product){
        return products.contains(product);
    }
}
