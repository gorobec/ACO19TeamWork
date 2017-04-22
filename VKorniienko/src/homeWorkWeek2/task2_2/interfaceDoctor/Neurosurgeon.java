package homeWorkWeek2.task2_2.interfaceDoctor;

/**
 * Created by volodymyrkorniienko on 11.04.17.
 */
public class Neurosurgeon extends Surgeon {

    private String academicDegree;

    public Neurosurgeon(String name, String surname, int experience, String academicDegree) {
        super(name, surname, experience);
        this.academicDegree = academicDegree;
    }
}
