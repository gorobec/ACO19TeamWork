package week4.day1.generics.product;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Container<T extends Product & Comparable<Product>> {
    private final List<T> items;

    public Container() {
        this.items = new LinkedList<>();
    }

    public void add(T item){
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Container{");
        sb.append("items=").append(Arrays.toString(items.toArray()));
        sb.append('}');
        return sb.toString();
    }
}
