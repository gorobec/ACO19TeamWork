package week1.classwork.task.candidateTask.model;

/**
 * Created by SmooZzzie on 02.04.2017.
 */
public class Candidate {

    private String name;
    private String secondName;
    private String phone;
    private String address;

    private int birthYear;

    private int id;

    public Candidate(String name, String secondName, String phone, String address, int birthYear, int id) {

        this.name = name;
        this.secondName = secondName;
        this.phone = phone;
        this.address = address;
        this.birthYear = birthYear;
        this.id = id;
    }

    public String showInfo() {
        return String.format("name: %s\t| second name: %s\t| phone: %s\t| address: %s\t| birth year: %d\t|\n",
                                    getName(),getSecondName(),getPhone(),getAddress(),getBirthYear());
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getId() {
        return id;
    }


}


