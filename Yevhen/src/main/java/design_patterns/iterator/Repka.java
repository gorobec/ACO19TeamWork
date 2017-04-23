package design_patterns.iterator;

import java.util.Iterator;

/**
 * Created by gorobec on 23.04.17.
 */
public class Repka implements Iterator{
    private Product[] products;
    private int size;
    private int position;

    public Repka(int size) {
        this.products = new Product[size];
    }


    public boolean add(Product product){

        if(product != null && size < products.length){
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
