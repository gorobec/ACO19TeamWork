package week3Day2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by volodymyrkorniienko on 23.04.17.
 */
public class Rozetka implements Iterator{

    private int position;
    List<Product> productList = new LinkedList<>();

    public boolean addProductToList(Product product) {
        return productList.add(product);
    }

    @Override
    public boolean hasNext() {
        return position < productList.size();
    }

    @Override
    public Object next() {
        return productList.get(position++);
    }
}
