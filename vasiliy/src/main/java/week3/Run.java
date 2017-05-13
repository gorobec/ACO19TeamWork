package week3;

public class Run {
    public static void main(String[] args) {


        Camera camera = new Camera("Camera", 1200, 15);

        Phone phone = new Phone("IPhone", 800, "iOS7");

        Container<Product> container = new Container<>();

        container.add(camera);
        container.add(phone);

        /*Container<String> container2 = new Container<>();
        container2.add("String");*/

    }
}
