package homeWorkWeek2.task2_4;

/**
 * Created by volodymyrkorniienko on 19.04.17.
 */
public class User {

    private String name;
    private String surname;
    private String dateOfBirth;

    public User(String name, String surname, String dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String toString() {
        return "Name: " + name + '\n' +
                "Surname: " + surname + '\n' +
                "Date of birth: " + dateOfBirth + '\n';
    }
}
