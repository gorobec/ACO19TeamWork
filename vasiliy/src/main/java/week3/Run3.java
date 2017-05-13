package week3;

import java.util.ArrayList;
import java.util.List;

public class Run3 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        List<Camera> cameras = new ArrayList<>();
        List<Phone> phones = new ArrayList<>();

        List<Object> list = new ArrayList<>();

        Utils.copy(cameras, products);
        Utils.copy(cameras, list);
        Utils.copy(cameras, cameras);

        //Utils.copy(cameras, phones); // - NOT allowed
        //Utils.copy(products, phones); // - NOT allowed
    }
}
