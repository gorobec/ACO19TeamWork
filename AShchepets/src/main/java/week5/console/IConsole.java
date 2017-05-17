package week5.console;

/**
 * Created by SmooZzzie on 17.05.2017.
 */
public interface IConsole {

    String pvm();
    String ls();
    String ls(String... option);
    void cd(String fileName);
    void mkdir(String dirName);
    void touch(String... fileNames);
    void cp(String oldName, String NewNameOrDir);
    void mv(String fileName, String destinationDirectory);
    void rm(String fileName);
    String tree();

}
