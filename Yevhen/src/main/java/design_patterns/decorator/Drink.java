package design_patterns.decorator;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public abstract class Drink extends Product{

    public Drink(Additive additive){
        this.price = this.price + additive.price;
        this.name = String.format("%s, %s",this.name, additive.name);
    }

    public Drink() {

    }
}
