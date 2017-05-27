package design_patterns.state;

/**
 * Created by gorobec on 27.05.17.
 */
public class MakeCoffeeState implements CoffeeMachineState {

    private CoffeeMachine coffeeMachine;
    public MakeCoffeeState(CoffeeMachine coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    @Override
    public void takeMoney() throws InterruptedException {
        System.out.println("Money already in. Making coffee");
        Thread.sleep(3000);
        coffeeMachine.setCurrentState(coffeeMachine.getNoMoneyState());
        System.out.println("Done!");
    }

    @Override
    public void giveChange() throws InterruptedException {
        System.out.println("Take your change. Making coffee");
        Thread.sleep(3000);
        coffeeMachine.setCurrentState(coffeeMachine.getNoMoneyState());
        System.out.println("Done!");

    }

    @Override
    public void makeChoice() throws InterruptedException {
        System.out.println("Already made choice. Making coffee");
        Thread.sleep(3000);
        coffeeMachine.setCurrentState(coffeeMachine.getNoMoneyState());
        System.out.println("Done!");

    }

    @Override
    public void makeCoffee() throws InterruptedException {
        System.out.println("Already making coffee");
        Thread.sleep(3000);
        coffeeMachine.setCurrentState(coffeeMachine.getNoMoneyState());
        System.out.println("Done!");
    }
}
