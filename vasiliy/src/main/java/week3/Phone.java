package week3;

public class Phone extends Product {
    String model;

    public Phone(String name, int price, String model) {
        super(name, price);
        this.model = model;
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
