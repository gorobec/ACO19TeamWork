package design_patterns.decorator;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public abstract class Additive extends Product {


    public Additive (Additive additive){
        this.price = this.price + additive.price;
        this.name = String.format("%s, %s",this.name, additive.name);
    }

    public Additive() {

    }
}
