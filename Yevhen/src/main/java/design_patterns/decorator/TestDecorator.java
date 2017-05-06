package design_patterns.decorator;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class TestDecorator {
    public static void main(String[] args) {
        Drink espresso  = new Espresso(new Milk(new Chocolate()));
        System.out.println(espresso);

        Drink black = new BlackCoffee(new Chocolate(new Sugar(new Sugar())));
        Drink cappuccino = new Cappuccino(new Milk(new Chocolate(new Sugar(new Sugar()))));

        Latte latte = new Latte();

        System.out.println(latte);

        System.out.println(black);

        System.out.println(cappuccino);
    }
}
