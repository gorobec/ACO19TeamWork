package design_patterns.decorator;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Sugar extends Additive {
    private static final String NAME = "Sugar";
    private static final int PRICE = 1;

    public Sugar() {
        super();
        this.name = NAME;
        this.price = PRICE;
    }

    public Sugar(Additive additive) {
        super(additive);
        this.name = String.format("%s, %s",NAME, additive.name);;
        this.price = PRICE + additive.price;
    }
}
