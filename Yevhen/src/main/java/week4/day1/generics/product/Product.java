package week4.day1.generics.product;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public abstract class Product implements Comparable<Product> {
    private final String name;
    private final long price;

    public Product(String name, long price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        return sb.toString();
    }
}
