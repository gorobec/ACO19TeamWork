package design_patterns.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gorobec on 23.04.17.
 */
public class Hotline {
    private List products = new LinkedList();


    public boolean addProducts(Iterator iterator){
        while (iterator.hasNext()){
            products.add(iterator.next());
        }
        return true;
    }


    public String products(){
        return Arrays.toString(products.toArray());
    }
}
