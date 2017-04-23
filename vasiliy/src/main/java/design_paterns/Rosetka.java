package design_paterns;

import data_structures.MyLinkedList;
import data_structures.MyList;

import java.util.Iterator;

public class Rosetka implements Iterator {
    private MyList products = new MyLinkedList();
    int position;

    public boolean addProduct(Product product) {
        if (product != null) {
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
