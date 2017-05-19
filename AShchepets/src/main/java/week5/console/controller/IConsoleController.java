package week5.console.controller;

/**
 * Created by SmooZzzie on 17.05.2017.
 */
public interface IConsoleController {

    String pvm();
    String ls();
    void cd(String[] nextValues);
    void mkdir(String[] nextValues);
    void touch(String[] nextValues);
    void cp(String[] nextValues);
    void mv(String[] nextValues);
    void rm(String[] nextValues);
    String tree();
    String help();
}
