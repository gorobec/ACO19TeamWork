package homeWorkWeek2.task2_2.interfaceDoctor;

/**
 * Created by volodymyrkorniienko on 11.04.17.
 */
public class Surgeon implements Doctor {

    private String name;
    private String surname;
    private int experience;

    public Surgeon(String name, String surname, int experience) {
        this.name = name;
        this.surname = surname;
        this.experience = experience;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public void heal() {
        if (this.experience > 3) {
            System.out.println("You are ready to hill people");
        } else {
            System.out.println("Studying!!!");
        }
    }
}
