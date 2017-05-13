package week3;

public class Camera extends Product {
    int pixels;

    public Camera(String name, long price, int pixels) {
        super(name, price);
        this.pixels = pixels;
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
