package design_patterns.decorator;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Milk extends Additive {
    private static final String NAME = "Milk";
    private static final int PRICE = 5;
    public Milk() {
        super();
        this.name = NAME;
        this.price = PRICE;
    }

    public Milk(Additive additive) {
        super(additive);
        this.name = String.format("%s, %s",NAME, additive.name);;
        this.price = PRICE + additive.price;
    }
}
