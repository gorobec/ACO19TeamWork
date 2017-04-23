package week3Day2;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Iterator;

/**
 * Created by volodymyrkorniienko on 23.04.17.
 */
public class Run {
    public static void main(String[] args) {

        Hotline hotline = new Hotline();
        Rozetka rozetka = new Rozetka();
        Repka repka = new Repka(10);

        Product product = new Product("Product1", 200);
        Product product1 = new Product("Product2", 200);
        Product product2 = new Product("Product3", 200);
        Product product3 = new Product("Product4", 200);
        Product product4 = new Product("Product5", 200);
        Product product5 = new Product("Product6", 200);

        rozetka.addProductToList(product2);
        rozetka.addProductToList(product3);

        repka.add(product4);
        repka.add(product5);

        hotline.addProductToList(repka);
        hotline.addProductToList(rozetka);
        System.out.println(hotline);
    }
}
