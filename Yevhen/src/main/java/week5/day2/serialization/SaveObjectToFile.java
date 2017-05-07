package week5.day2.serialization;

import week5.day1.clone.Child;
import week5.day1.clone.Man;
import week5.day1.clone.Woman;

import java.io.*;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class SaveObjectToFile {
    public static void main(String[] args) {
        Child child = new Child("Artur", 15);
        Woman wife = new Woman("Alice", 35, child);
        Man man = new Man("John", 40, wife);

        try(ObjectOutputStream os = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("./Yevhen/src/main/resources/serialization/Man.txt")))) {
            os.writeObject(man);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
