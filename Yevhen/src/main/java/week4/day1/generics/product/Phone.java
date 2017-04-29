package week4.day1.generics.product;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Phone extends Product {

    private final String model;

    public Phone(String name, long price, String model) {
        super(name, price);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Phone{");
        sb.append(super.toString());
        sb.append(", model='").append(model).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
