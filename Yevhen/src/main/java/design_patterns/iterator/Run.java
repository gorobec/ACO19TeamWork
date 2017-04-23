package design_patterns.iterator;

/**
 * Created by gorobec on 23.04.17.
 */
public class Run {
    public static void main(String[] args) {
        Product product = new Product("TV", 250);
        Product product2 = new Product("PC", 1250);
        Product product3 = new Product("Phone", 150);
        Product product4 = new Product("Laptop", 2050);

        Rozetka rozetka = new Rozetka();
        Repka repka = new Repka(5);

        rozetka.add(product);
        rozetka.add(product2);

        repka.add(product3);
        repka.add(product4);

        Hotline hotline = new Hotline();

        hotline.addProducts(rozetka);
        hotline.addProducts(repka);

        System.out.println(hotline.products());

    }
}
