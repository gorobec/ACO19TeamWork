package week1.task3.model;

import static week1.task3.utils.CommonUtils.checkOnNull;

/**
 * Created by SmooZzzie on 11.04.2017.
 */
public class Parking {

    private static final int PARKING_PLACES = 10;

    private String address;
    private Bike[] parkedBikes = new Bike[PARKING_PLACES];
    private boolean isOpened;


    public Parking(String address, boolean isOpened) {
        this.address = address;
        this.isOpened = isOpened;
    }

    public int getPARKING_PLACES() {
        return PARKING_PLACES;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Bike[] getParkedBikes() {
        return parkedBikes;
    }

    public void setParkedBikes(Bike[] parkedBikes) {
        this.parkedBikes = parkedBikes;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }

    public boolean addMotoOnLastFreePlace(Bike bike) {

        if (checkOnNull(bike)) return false;

        if (checkOnNull(parkedBikes)) {
            parkedBikes[0] = bike;
            return true;
        } else {
            for (int i = 0; i < PARKING_PLACES; i++) {
                if (parkedBikes[i] == null) {
                    parkedBikes[i] = bike;
                    return true;
                }
            }
        }

        return false;
    }



    public boolean takeLastMoto() {

        if (checkOnNull(parkedBikes)) return false;

        int lastOccupiedPlace = 0;

        for (int i = 0; i < PARKING_PLACES; i++) {
            if (parkedBikes[i] != null) lastOccupiedPlace = i;
        }

        parkedBikes[lastOccupiedPlace] = null;
        return true;
    }



    public boolean addMotoByPlaceNumber(int place, Bike bike) {

        if ((checkOnNull(bike)) || (!checkOnNull(parkedBikes[place - 1]))) return false;

        parkedBikes[place - 1] = bike;
        return true;
    }

    public boolean takeMotoByPlaceNumber(int place) {

        if ((checkOnNull(parkedBikes)) || checkOnNull(parkedBikes[place - 1])) return false;

        parkedBikes[place - 1] = null;
        return true;
    }

    public boolean clearGaragePlaces() {

        if (checkOnNull(parkedBikes)) return false;

        for (int i = 0; i < PARKING_PLACES; i++) {
            if (!checkOnNull(parkedBikes[i])) parkedBikes[i] = null;
        }
        return true;
    }

    public void open() {
        isOpened = true;
    }

    public void close() {
        isOpened = false;
    }

    public void changeAddress(String newAddress) {
        address = newAddress;
    }

    public void showAllInGarage() {
        for (int i = 0; i < PARKING_PLACES; i++) {
            System.out.print("Place " + (i + 1) + ": ");
            if (parkedBikes[i] == null) System.out.print("None.\n");
            else System.out.print(parkedBikes[i].getModel() + ".\n");
        }
    }
}
