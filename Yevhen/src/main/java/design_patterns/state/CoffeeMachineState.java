package design_patterns.state;

/**
 * Created by gorobec on 27.05.17.
 */
public interface CoffeeMachineState {


    void takeMoney() throws InterruptedException;
    void giveChange() throws InterruptedException;
    void makeChoice() throws InterruptedException;
    void makeCoffee() throws InterruptedException;
}
