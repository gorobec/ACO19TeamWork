package design_patterns.decorator;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public abstract class Product {
    protected String name;
    protected int price;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price).append(" $");
        sb.append('}');
        return sb.toString();
    }
}
