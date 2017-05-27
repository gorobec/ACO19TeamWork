package design_patterns.state;

/**
 * Created by gorobec on 27.05.17.
 */
public class NoMoneyState implements CoffeeMachineState {
    private CoffeeMachine coffeeMachine;

    public NoMoneyState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void takeMoney() {
        System.out.println("Take money");
        coffeeMachine.setCurrentState(coffeeMachine.getMoneyInState());
    }

    @Override
    public void giveChange() {
        System.out.println("First put money!");

    }

    @Override
    public void makeChoice() {
        System.out.println("First put money!");

    }

    @Override
    public void makeCoffee() {
        System.out.println("First put money!");

    }
}
