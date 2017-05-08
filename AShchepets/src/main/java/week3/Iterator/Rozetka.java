package week3.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by SmooZzzie on 08.05.2017.
 */
public class Rozetka implements Iterator<Product> {

    private List<Product> products;
    private int currIndex = 0;


    public Rozetka(int size) {
        products = new ArrayList<>(size);
    }

    public boolean addProduct(Product newProduct) {
        if (newProduct == null) return false;
       return products.add(newProduct);
    }

    @Override
    public Product next() {
        Product ret = products.get(currIndex++);
        return ret;
    }

    @Override
    public boolean hasNext() {
        return currIndex < products.size();
    }

}
