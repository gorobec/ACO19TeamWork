package week2.day1;

/**
 * Created by gorobec on 08.04.17.
 */
public abstract class Employee implements Comparable{
    private String name;
    private String surname;
    private int age;

    public Employee(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void work();

    public String toString() {
        return String.format("Name - %s, surname - %s, age - %d", name, surname, age);
    }

    @Override
    public int compareTo(Object obj) {

        Employee employee = (Employee) obj;
        int nameCompare = name.compareTo(employee.name);
        if(nameCompare != 0) return nameCompare;
        int surnameCompare = surname.compareTo(employee.surname);
        if(surnameCompare != 0) return surnameCompare;
        return Integer.compare(age, employee.age);
    }

  /*  @Override
    public boolean equals(Object obj) {

        if(obj == null) return false;

        if(this == obj) return true;

        if(!(obj instanceof Employee)) return false;

        Employee employee = (Employee) obj;

        if(!this.name.equals(employee.name)) return false;
        if(!this.surname.equals(employee.surname)) return false;
        return this.age == employee.age;

    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (age != employee.age) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return surname != null ? surname.equals(employee.surname) : employee.surname == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }
}
