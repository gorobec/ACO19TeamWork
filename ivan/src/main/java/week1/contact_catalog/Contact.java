package week1.contact_catalog;

/**
 * @author Ivan Knyazev on 18.04.2017
 * @since JDK 1.8
 */
public class Contact {

    private String name;
    private String phone;

    private static final int NUM_LENGHT = 13;
    private static final String startPref = "+380";

    public Contact(String name, String phone) {
        if (chekPhoneNumber(phone) && chekName(name)) {
            this.name = name;
            this.phone = phone;
        }
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public boolean chekPhoneNumber (String phone) {

        if (phone == null) return false;
        if (phone.length() != NUM_LENGHT) return false;
        if (!phone.startsWith(startPref, 0)) return false;

        char[] chArrPhone = phone.toCharArray();
        if (chArrPhone[0] != 43) return false;
        for (int i = 1; i < phone.length(); i++) {
            if (chArrPhone[i] < 48 || chArrPhone[i] > 57){
                return false;
            }
        }
        return true;
    }

    public boolean chekName (String name) {
        if (name == null) return false;
        if (name == "") return false;
        return true;
    }

    public String asString() {
        return String.format("Name: %-7s, Phone: %s", name, phone);
    }

}
