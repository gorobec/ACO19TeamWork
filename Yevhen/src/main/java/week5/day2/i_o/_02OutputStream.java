package week5.day2.i_o;

import utils.Action;
import utils.FileUtils;
import utils.TimeCounter;

import java.io.*;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class _02OutputStream {
    public static void main(String[] args) {
        File fileSrc = new File("./Yevhen/src/main/resources/src.txt");
        File fileDest = new File("./Yevhen/src/main/resources/dest.txt");

        TimeCounter.countProcessTime(new Action() {
            @Override
            public void run() {
                System.out.printf("Copied successfully - %b\n", FileUtils.copyFiles(fileSrc, fileDest));
            }
        });
    }
}
