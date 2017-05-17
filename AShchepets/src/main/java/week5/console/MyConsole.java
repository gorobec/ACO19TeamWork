package week5.console;

import java.io.File;

/**
 * Created by SmooZzzie on 17.05.2017.
 */
public class MyConsole implements IConsole {

    private final static String DEFAULT_PATH = "C:\\Users\\SmooZzzie\\";

    private File currFile;

    MyConsole(){
        currFile = new File(DEFAULT_PATH);
    }

    @Override
    public String pvm() {
        return null;
    }

    @Override
    public String ls() {
        return null;
    }

    @Override
    public String ls(String... option) {
        return null;
    }

    @Override
    public void cd(String fileName) {

    }

    @Override
    public void mkdir(String dirName) {

    }

    @Override
    public void touch(String... fileNames) {

    }

    @Override
    public void cp(String oldName, String NewNameOrDir) {

    }

    @Override
    public void mv(String fileName, String destinationDirectory) {

    }

    @Override
    public void rm(String fileName) {

    }

    @Override
    public String tree() {
        return null;
    }

    public void readTheCommand() {
    }
}
