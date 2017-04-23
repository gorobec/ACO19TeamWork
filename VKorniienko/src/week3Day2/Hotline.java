package week3Day2;

import java.util.*;

/**
 * Created by volodymyrkorniienko on 23.04.17.
 */
public class Hotline {

    List productList = new ArrayList();

    public boolean addProductToList(Iterator iterator) {
        while (iterator.hasNext()) {
            productList.add(iterator.next());
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hotline{" +
                "productList=" + productList +
                '}';
    }
}
