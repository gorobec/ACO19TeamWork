package week1.home1;

public class Contact {
    private static final int PHONE_LENGTH = 10;

    private String name;
    private String phone;

    public boolean init(String name, String phone) {
        if (validatePhone(phone)) {
            this.phone = phone;
            this.name = name;
            return true;
        }
        return false;
    }

    public boolean validatePhone(String phone) {
        int len = phone.length();
        if (len != PHONE_LENGTH) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String asString() {
        return String.format("Name: %s, phone: %s", name, phone);
    }

    public boolean isLife() {
        String prefix = phone.substring(0,3);
        return prefix.equals("063") ||  prefix.equals("093");
    }

    public boolean isKievStar() {
        String prefix = phone.substring(0,3);
        return prefix.equals("067") ||  prefix.equals("097") || prefix.equals("068") ||  prefix.equals("098");
    }
}