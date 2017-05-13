package week3;

import java.util.LinkedList;
import java.util.List;

public class Container<T extends Product & Comparable<Product>> {
    List<T> items;

    public Container() {
        this.items = new LinkedList<T>();
    }

    public void add(T t){
        items.add(t);
    }
}
