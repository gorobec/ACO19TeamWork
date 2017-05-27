package design_patterns.state;

/**
 * Created by gorobec on 27.05.17.
 */
public class CoffeeMachine implements CoffeeMachineState{


    private CoffeeMachineState noMoneyState;
    private CoffeeMachineState moneyInState;
    private CoffeeMachineState makeCoffeeState;
    private CoffeeMachineState choiceState;

    private CoffeeMachineState currentState;


    public CoffeeMachine() {

        noMoneyState = new NoMoneyState(this);
        moneyInState = new MoneyInState(this);
        makeCoffeeState = new MakeCoffeeState(this);
        choiceState = new ChoiceState(this);

        currentState = noMoneyState;
    }

    public CoffeeMachineState getNoMoneyState() {
        return noMoneyState;
    }

    public CoffeeMachineState getMoneyInState() {
        return moneyInState;
    }

    public CoffeeMachineState getMakeCoffeeState() {
        return makeCoffeeState;
    }

    public CoffeeMachineState getChoiceState() {
        return choiceState;
    }

    public void setCurrentState(CoffeeMachineState currentState) {
        this.currentState = currentState;
    }

    @Override
    public void takeMoney() throws InterruptedException {
        currentState.takeMoney();
    }

    @Override
    public void giveChange() throws InterruptedException {
        currentState.giveChange();
    }

    @Override
    public void makeChoice() throws InterruptedException {
        currentState.makeChoice();
    }

    @Override
    public void makeCoffee() throws InterruptedException {
        currentState.makeCoffee();
    }
}
