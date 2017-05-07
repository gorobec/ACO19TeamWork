package week5.day2.i_o;

import java.io.*;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class _01InputStream {
    public static void main(String[] args) {
        File fileSrc = new File("./Yevhen/src/main/resources/src.txt");
        File fileDest = new File("./Yevhen/src/main/resources/dest.txt");

        try {
            InputStream is = new FileInputStream(fileSrc);
            OutputStream os = new FileOutputStream(fileDest);

            byte[] readBytes = new byte[1024];

            int count;



            while ((count = is.read(readBytes)) > 0){
                System.out.println(count);
                os.write(readBytes, 0, count);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Something go wrong");
            e.printStackTrace();
        }
    }
}
