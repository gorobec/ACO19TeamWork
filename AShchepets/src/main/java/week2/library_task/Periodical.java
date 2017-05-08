package week2.library_task;

/**
 * Created by SmooZzzie on 27.04.2017.
 */
public class Periodical extends Edition {

    private PeriodicalType type;
    private Periodicity periodicity;


    // constructor without quantity
    public Periodical(String editionName, int yearOfPublishing, PeriodicalType type, Periodicity periodicity) {
        super(editionName, yearOfPublishing);
        this.type = type;
        this.periodicity = periodicity;
    }

    // constructor with quantity
    public Periodical(String editionName, int yearOfPublishing, int quantity, PeriodicalType type, Periodicity periodicity) {
        super(editionName, yearOfPublishing, quantity);
        this.type = type;
        this.periodicity = periodicity;
    }

    public final String info() {
        return super.toString() + " " + type + " " + periodicity + super.getEditionReaders().toString();
    }

}
