package design_patterns.state;

/**
 * Created by gorobec on 27.05.17.
 */
public class TestCoffeMachine {
    public static void main(String[] args) throws InterruptedException {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.makeCoffee();
    }
}
