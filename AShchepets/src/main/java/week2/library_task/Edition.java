package week2.library_task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by SmooZzzie on 27.04.2017.
 */
public abstract class Edition implements Comparable<Edition> {

    private static final int DEFAULT_QUANTITY_OF_EDITION = 5;

    private String editionName;
    private int yearOfPublishing;
    private int quantity;

    private List<Reader> editionReaders;

    public Edition(String editionName, int yearOfPublishing) {
        this.editionName = editionName;
        this.yearOfPublishing = yearOfPublishing;
        quantity = DEFAULT_QUANTITY_OF_EDITION;
        editionReaders = new ArrayList<>(quantity);
    }

    public Edition(String editionName, int yearOfPublishing, int quantity) {
        this.editionName = editionName;
        this.yearOfPublishing = yearOfPublishing;
        this.quantity = quantity;
        editionReaders = new ArrayList<>(quantity);
    }

    public List<Reader> getEditionReaders() {
        return editionReaders;
    }

    public String getEditionName() {
        return editionName;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return editionName + ", " + yearOfPublishing + "\t| quantity: " + quantity;
    }

    @Override
    public int compareTo(Edition o) {
        return this.editionName.compareTo(o.editionName);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean addReader(Reader reader) {

        if (reader == null ||quantity == 0 || reader.isBanned()) return false;

        editionReaders.add(reader);
        Collections.sort(editionReaders);

        return true;
    }
}
