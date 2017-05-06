package design_patterns.decorator;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Chocolate extends Additive {
    private static final String NAME = "Chocolate";
    private static final int PRICE = 3;

    public Chocolate() {
        super();
        this.name = NAME;
        this.price = PRICE;
    }

    public Chocolate(Additive additive) {
        super(additive);
        this.name = String.format("%s, %s",NAME, additive.name);;
        this.price = PRICE + additive.price;
    }
}
