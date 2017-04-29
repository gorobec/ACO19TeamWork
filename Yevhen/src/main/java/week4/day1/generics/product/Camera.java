package week4.day1.generics.product;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Camera extends Product {

    private final int pixels;

    public Camera(String name, long price, int pixels) {
        super(name, price);
        this.pixels = pixels;
    }

    public int getPixels() {
        return pixels;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Camera{");
        sb.append(super.toString());
        sb.append(", pixels=").append(pixels);
        sb.append('}');
        return sb.toString();
    }
}
