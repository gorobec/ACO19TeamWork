package design_patterns.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gorobec on 23.04.17.
 */
public class Rozetka implements Iterator{
    private List products = new ArrayList();
    private int position;

    public boolean add(Product product){

        if(product != null){
            return products.add(product);
        }
        return false;

    }

    @Override
    public boolean hasNext() {
        return position < products.size();
    }

    @Override
    public Object next() {
        return products.get(position++);
    }
}
