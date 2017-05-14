package design_patterns.dao_mvc.model;

import design_patterns.dao_mvc.exceptions.AgeValidationException;
import design_patterns.dao_mvc.exceptions.NameValidationException;
import design_patterns.dao_mvc.exceptions.PhoneValidationException;
import design_patterns.dao_mvc.utils.Validation;

import static design_patterns.dao_mvc.utils.Validation.*;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class User {
    private String name;
    private String surname;
    private int age;
    private String phoneNumber;

    public User() {
    }

    public User(String name, String surname, int age, String phoneNumber) throws NameValidationException, AgeValidationException, PhoneValidationException {
        validateNameSurname(name);
        this.name = name;
        validateNameSurname(surname);
        this.surname = surname;
       validateAge(age);
        this.age = age;
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (surname != null ? !surname.equals(user.surname) : user.surname != null) return false;
        return phoneNumber != null ? phoneNumber.equals(user.phoneNumber) : user.phoneNumber == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", age=").append(age);
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
