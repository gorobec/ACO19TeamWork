package week3.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by SmooZzzie on 08.05.2017.
 */
public class Hotline {

    private List<Product> products;

    public Hotline(int size) {
        products = new ArrayList<>(size);
    }

    public boolean addProduct(Iterator<Product> iterator) {

        while (iterator.hasNext()) {
            products.add(iterator.next());
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hotline{" +
                "products=" + products +
                '}';
    }
}
