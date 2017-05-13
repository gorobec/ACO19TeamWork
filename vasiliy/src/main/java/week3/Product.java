package week3;

public abstract class Product implements Comparable<Product> {
    private String name;
    private long price;

    public Product(String name, long price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
