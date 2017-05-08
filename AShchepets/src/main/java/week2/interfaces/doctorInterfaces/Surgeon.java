package week2.interfaces.doctorInterfaces;

/**
 * Created by SmooZzzie on 22.04.2017.
 */
public class Surgeon implements Doctor {

    private String name;
    private int overallExperienceAsSurgeon;

    public Surgeon(String name, int overallExperienceAsSurgeon) {
        this.name = name;
        this.overallExperienceAsSurgeon = overallExperienceAsSurgeon;
    }

    public int getOverallExperienceAsSurgeon() {
        return overallExperienceAsSurgeon;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void work() {
        overallExperienceAsSurgeon++;
        System.out.println("I'm doing a simple surgery! My work experience now: " + overallExperienceAsSurgeon);
    }
}
