package week5.day2.file_access;

import java.io.File;
import java.io.IOException;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class _01_File {
    public static void main(String[] args) {
        File file = new File("./Yevhen/src/main/resources/file.txt");

        System.out.printf("does file exist - %b\n", file.exists());
        System.out.printf("Is directory - %b\n", file.isDirectory());
        System.out.printf("Is file - %b\n", file.isFile());
        System.out.printf("File  length - %d\n", file.length());
        System.out.printf("File  parent - %s\n", file.getParent());

        try {
            System.out.printf("Was created - %b\n", file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("does file exist - %b\n", file.exists());
        System.out.printf("Is directory - %b\n", file.isDirectory());
        System.out.printf("Is file - %b\n", file.isFile());
        System.out.printf("File  length - %d\n", file.length());
        System.out.printf("File  parent - %s\n", file.getParent());

        System.out.printf("Was renamed - %b\n", file.renameTo(new File("E:\\Teaching\\ACO19TeamWork\\Yevhen\\src\\main\\resources2\\file.txt")));

//        System.out.printf("Was deleted - %b\n", file.delete());
//        System.out.printf("does file exist - %b\n", file.exists());

//        Removing parent directory

        File parent = file.getParentFile();
        System.out.printf("Was deleted - %b\n", parent.delete());



        System.out.printf("Is directory - %b\n", parent.isDirectory());
        File[] files = parent.listFiles();





    }

}
