package week1.task3.model;

/**
 * Created by SmooZzzie on 11.04.2017.
 */
public class Bike {

    private String model;
    private int price;
    private boolean isGoodWorking = true;

    public Bike(String model) {
        this.model = model;
    }

    public Bike(String model, boolean isGoodWorking) {
        this.model = model;
        this.isGoodWorking = isGoodWorking;
    }

    public Bike(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public Bike(String model, int price, boolean isGoodWorking) {
        this.model = model;
        this.price = price;
        this.isGoodWorking = isGoodWorking;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isGoodWorking() {
        return isGoodWorking;
    }

    public void setGoodWorking(boolean goodWorking) {
        isGoodWorking = goodWorking;
    }
}
