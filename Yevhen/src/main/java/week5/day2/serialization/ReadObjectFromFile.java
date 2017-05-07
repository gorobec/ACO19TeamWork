package week5.day2.serialization;

import week5.day1.clone.Man;

import java.io.*;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class ReadObjectFromFile {
    public static void main(String[] args) {

        Man man = null;

        try(ObjectInputStream os = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("./Yevhen/src/main/resources/serialization/Man.txt")))) {
            man = (Man) os.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(man);
    }
}
