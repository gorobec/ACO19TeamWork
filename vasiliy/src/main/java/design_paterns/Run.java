package design_paterns;

public class Run {
    public static void main(String[] args) {
        Product product1 = new Product("Name1", 1);
        Product product2 = new Product("Name2", 2);
        Product product3 = new Product("Name3", 3);
        Product product4 = new Product("Name4", 4);

        Repka repka = new Repka();
        repka.addProduct(product3);
        repka.addProduct(product4);

        Rosetka rosetka = new Rosetka();
        rosetka.addProduct(product1);
        rosetka.addProduct(product2);

        HotLine hotLine = new HotLine();
        hotLine.addProducts(repka);
        hotLine.addProducts(rosetka);

        hotLine.showProducts();
    }
}
