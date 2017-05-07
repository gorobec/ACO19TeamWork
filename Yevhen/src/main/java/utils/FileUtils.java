package utils;

import week5.day1.clone.Man;

import java.io.*;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class FileUtils {
    public static boolean deleteFileRecursively(String path){

        File file = new File(path);
        if(file.isFile()){
            return file.delete();
        } else {
            File[] files = file.listFiles();
            if(files != null) {
                for (File insideFile : files) {
                    deleteFileRecursively(insideFile.getPath());
                }
            }
            return file.delete();
        }
    }


    public static boolean deleteFileRecursively(File file){

        if(file.isFile()){
            return file.delete();
        } else {
            File[] files = file.listFiles();
            if(files != null) {
                for (File insideFile : files) {
                    deleteFileRecursively(insideFile);
                }
            }
            return file.delete();
        }
    }

    public static boolean copyFiles(File src, File dest){
        try {
            InputStream is = new FileInputStream(src);
            OutputStream os = new FileOutputStream(dest);

            byte[] readBytes = new byte[1024];
            int count;

            while ((count = is.read(readBytes)) > 0){
                os.write(readBytes, 0, count);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Something go wrong");
            e.printStackTrace();
        }
        return src.length() == dest.length();
    }

    /*public static boolean copyFilesFast(File src, File dest){
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new BufferedInputStream(new FileInputStream(src));
            os = new BufferedOutputStream(new FileOutputStream(dest));

            byte[] readBytes = new byte[1024];
            int count;

            while ((count = is.read(readBytes)) > 0){
                os.write(readBytes, 0, count);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Something go wrong");
            e.printStackTrace();
        } finally {
            try {
                if(is != null) {
                    is.close();
                }
                if(os != null){
                    os.flush();
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return src.length() == dest.length();
    }*/

    public static boolean copyFilesFast(File src, File dest){
        try (InputStream is = new BufferedInputStream(new FileInputStream(src));
                OutputStream os = new BufferedOutputStream(new FileOutputStream(dest))){

            byte[] readBytes = new byte[1024];
            int count;

            while ((count = is.read(readBytes)) > 0){
                os.write(readBytes, 0, count);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Something go wrong");
            e.printStackTrace();
        }

        return src.length() == dest.length();
    }

    public static Object serializedObject(Object o) {

        Object copy = null;
        File file = new File("./Yevhen/src/main/resources/serialization/Serialized.txt");

        try(ObjectOutputStream os = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(file)))) {


            os.writeObject(o);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream is = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream(file)))) {

            copy =  is.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return copy;
    }
}
