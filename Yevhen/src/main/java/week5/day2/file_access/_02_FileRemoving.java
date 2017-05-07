package week5.day2.file_access;

import java.io.File;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class _02_FileRemoving {
    public static void main(String[] args) {
        System.out.printf("Was folder deleted- %b\n",
                deleteFile("E:\\Teaching\\ACO19TeamWork\\Yevhen\\src\\main\\resources\\test_folder"));
    }

    public static boolean deleteFile(String path){


        File file = new File(path);


        if(file.isFile()){
            return file.delete();
        } else {
            File[] files = file.listFiles();
            for (File insideFile : files) {
                deleteFile(insideFile.getPath());
            }
            return file.delete();
        }
    }
}
