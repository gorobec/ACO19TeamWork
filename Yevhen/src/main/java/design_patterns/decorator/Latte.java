package design_patterns.decorator;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Latte extends Drink {
    private static final String NAME = "Latte";
    private static final int PRICE = 15;
    public Latte() {
        super();
        this.name = NAME;
        this.price = PRICE;
    }
    public Latte(Additive additive) {
        super(additive);
        this.name = String.format("%s, %s",NAME, additive.name);;
        this.price = PRICE + additive.price;

    }
}
