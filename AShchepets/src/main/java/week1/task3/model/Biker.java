package week1.task3.model;

import static week1.task3.utils.CommonUtils.checkOnNull;

/**
 * Created by SmooZzzie on 11.04.2017.
 */
public class Biker {

    private String name;
    private Bike bike;

    public Biker(String name) {
        this.name = name;
        this.bike = null;
    }

    public Biker(String name, Bike bike) {
        this.name = name;
        this.bike= bike;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public boolean buyMotocycle(Bike buyingMoto) {

        if (checkOnNull(buyingMoto) || !checkOnNull(bike)) return false;

        this.bike = buyingMoto;
        return true;
    }

    public boolean sellMotorcycle() {
        if (checkOnNull(bike)) return false;

        bike = null;
        return true;
    }

    public boolean fixMotorcycle() {

        if (bike.isGoodWorking()) return false;

        bike.setGoodWorking(true);
        return true;
    }

}
