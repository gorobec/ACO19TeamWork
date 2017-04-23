package design_paterns;

import java.util.Iterator;

public class Repka implements Iterator {

    private Product[] products = new Product[10];
    int size;
    int position;

    public boolean addProduct(Product product) {
        if (product != null && size < products.length) {
            products[size++] = product;
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        return position < size;
    }

    @Override
    public Object next() {
        return products[position++];
    }
}
