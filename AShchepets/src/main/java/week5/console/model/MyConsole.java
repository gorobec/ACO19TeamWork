package week5.console.model;

import java.io.File;

/**
 * Created by SmooZzzie on 17.05.2017.
 */
public class MyConsole {

    private final static String DEFAULT_PATH = "C:\\Users\\SmooZzzie";

    private File currDir;

    public MyConsole() {
        currDir = new File(DEFAULT_PATH);
    }

    public static String getDefaultPath() {
        return DEFAULT_PATH;
    }

    public File getCurrDir() {
        return currDir;
    }

    public void setCurrDir(File currFile) {
        this.currDir = currFile;
    }
}


