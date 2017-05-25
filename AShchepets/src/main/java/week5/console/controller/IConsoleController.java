package week5.console.controller;

/**
 * Created by SmooZzzie on 17.05.2017.
 */
public interface IConsoleController {

    // show path of current directory
    String pvm();

    // show list of files/directories of current directory
    String ls();

    // options: . - do nothing(cd itself)
    //          .. - change directory to parent directory
    //          nameOfDirectory - change directory to child dir with same name
    void cd(String[] nextValues);

    // make an empty dir in current directory
    void mkdir(String[] nextValues);

    // make an empty file(s) in current directory
    void touch(String[] nextValues);

    // options: first value - always the name of copied file in curr dir
    //          second value: name of the file - copy file to the same directory with the name of second value
    //                        absolute path\filename - copy file to the certain directory with the name instead of "filename"
    void cp(String[] nextValues);

    // options: first value - always the name of copied file in curr dir
    //          second value: .. - mv to the parent directory
    //                        absolute path\filename - copy file to the certain directory with the name instead of "filename"

    // *****didn't released function of moving to the child directory****
    void mv(String[] nextValues);

    // deleting a file
    void rm(String[] nextValues);

    // show a filesystem tree
    String tree();

    // show a reference (NOT REALLY :D)
    String help();
}
