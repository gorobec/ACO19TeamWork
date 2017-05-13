package week6.day1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import week5.day1.clone.Child;
import week5.day1.clone.Man;
import week5.day1.clone.Woman;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class JsonSerialization {
    public static void main(String[] args) {
        Child child = new Child("Artur", 15);
        Woman wife = new Woman("Alice", 35, child);
        Man man = new Man("John", 40, wife);

        Gson gson = new Gson();

        GsonBuilder gsonBuilder = new GsonBuilder();


//        String json = gson.toJson(man);
        String json = gsonBuilder.setPrettyPrinting().create().toJson(man);

        System.out.println(json);

        Man copy = gson.fromJson(json, Man.class);
        System.out.println(copy);
    }
}
