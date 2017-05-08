package week3.Iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by SmooZzzie on 08.05.2017.
 */
public class Repka implements Iterator<Product>{

    private Product[] products;
    private int currIndex = 0;
    private int actualSize= 0;

    public Repka(int size) {
         products = new Product[size];
    }

    public boolean addProduct(Product newProduct) {

        if (newProduct == null) return false;
        products[actualSize++] = newProduct;
        return true;
    }

    @Override
    public Product next() {
        Product ret = products[currIndex++];
        return ret;
    }

    @Override
    public boolean hasNext() {
        return currIndex < actualSize;
    }

}
