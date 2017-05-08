package week1.task1.model;

/**
 * Created by SmooZzzie on 09.04.2017.
 */
public class Contact {

    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void showContactInfo() {
        System.out.println(String.format("Contact %s\t\t| phone: %s\t\t|",
                getName(), getPhone()));
    }
}
