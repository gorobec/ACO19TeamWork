package design_patterns.state;

/**
 * Created by gorobec on 27.05.17.
 */
public class ChoiceState implements CoffeeMachineState {

    private CoffeeMachine coffeeMachine;

    public ChoiceState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void takeMoney() {
        System.out.println("Money already in. Make your choice");
    }

    @Override
    public void giveChange() {
        System.out.println("Take your money.");
        coffeeMachine.setCurrentState(coffeeMachine.getNoMoneyState());
    }

    @Override
    public void makeChoice() {
        System.out.println("You have already make choice");
    }

    @Override
    public void makeCoffee() {
        System.out.println("Making coffee");
        coffeeMachine.setCurrentState(coffeeMachine.getMakeCoffeeState());
    }
}
