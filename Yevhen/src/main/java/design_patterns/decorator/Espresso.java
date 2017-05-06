package design_patterns.decorator;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Espresso extends Drink {

    private static final String NAME = "Espresso";
    private static final int PRICE = 10;
    public Espresso() {
        super();
        this.name = NAME;
        this.price = PRICE;
    }

    public Espresso(Additive additive) {
        super(additive);
        this.name = String.format("%s, %s",NAME, additive.name);;
        this.price = PRICE + additive.price;
    }
}
