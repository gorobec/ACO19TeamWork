package week2.library_task;

import java.io.*;

/**
 * Created by SmooZzzie on 24.05.2017.
 */
public class LibraryUtils {

    public static void serializeLibraryInFile(Library library) {

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("ACO19TeamWork\\AShchepets\\src\\main\\java\\week2\\library_task\\savedLibrary.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(library);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved.");
        }catch(IOException i) {
            i.printStackTrace();
        }
    }

    public static Library deserializeLibraryFromFile(File file) {
        try {
            FileInputStream fileIn = new FileInputStream("ACO19TeamWork\\AShchepets\\src\\main\\java\\week2\\library_task\\savedLibrary.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Library library = (Library) in.readObject();
            in.close();
            fileIn.close();
            return library;
        }catch(IOException i) {
            i.printStackTrace();
            return null;
        }catch(ClassNotFoundException c) {
            System.out.println("Library class not found");
            c.printStackTrace();
            return null;
        }
    }
}
