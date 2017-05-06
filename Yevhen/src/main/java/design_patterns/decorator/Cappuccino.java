package design_patterns.decorator;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Cappuccino extends Drink{
    private static final String NAME = "Cappuccino";
    private static final int PRICE = 11;

    public Cappuccino() {
        super();
        this.name = NAME;
        this.price = PRICE;
    }

    public Cappuccino(Additive additive) {
        super(additive);
        this.name = String.format("%s, %s",NAME, additive.name);;
        this.price = PRICE + additive.price;
    }
}
