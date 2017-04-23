package design_paterns;

import data_structures.MyArrayList;
import data_structures.MyList;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class HotLine {
    private MyList products = new MyArrayList();

    boolean addProducts(Iterator iterator) {
        while (iterator.hasNext()) {
            products.add(iterator.next());
        }
        return true;
    }

    public void showProducts() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }
}
