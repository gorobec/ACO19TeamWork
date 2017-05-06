package design_patterns.decorator;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class BlackCoffee extends Drink {
    private static final String NAME = "Black coffee";
    private static final int PRICE = 11;

    public BlackCoffee() {
        super();
        this.name = NAME;
        this.price = PRICE;
    }

    public BlackCoffee(Additive additive) {
        super(additive);
        this.name = String.format("%s, %s",NAME, additive.name);;
        this.price = PRICE + additive.price;
    }
}
