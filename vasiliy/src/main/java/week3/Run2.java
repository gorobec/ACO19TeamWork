package week3;

import java.util.ArrayList;
import java.util.List;

public class Run2 {
    public static void main(String[] args) {
        Camera camera = new Camera("Camera", 1200, 15);

        Phone phone = new Phone("IPhone", 800, "iOS7");

        List<Camera> cameras = new ArrayList<>();
        List<Phone> phones = new ArrayList<>();

        Utils.find(cameras, camera);
        Utils.find(phones, phone);
    }
}
