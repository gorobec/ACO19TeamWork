package design_patterns.dao_mvc.utils;

import design_patterns.dao_mvc.model.User;

import java.io.*;
import java.util.List;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class FileUtils {

    public static String readJsonFromFile(String filePath) {

        String result = null;

        try (BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))){

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = is.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
        } catch (FileNotFoundException e) {
//            TODO handle Exception
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean writeJsonToFile(String path, String json) {

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {

            writer.write(json);

        } catch (FileNotFoundException e) {
//            TODO handle Exception
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
