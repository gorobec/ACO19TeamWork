package week5.console.controller;

import week5.console.model.MyConsole;
import week5.console.view.ConsoleView;

import java.io.File;

/**
 * Created by SmooZzzie on 18.05.2017.
 */
public class ConsoleControllerImpIConsole implements IConsoleController {

    private ConsoleView consoleView;
    private MyConsole console;

    ConsoleControllerImpIConsole(ConsoleView consoleView, MyConsole console) {
        this.consoleView = consoleView;
        this.console = console;
    }

    public void startWorking() {

        consoleView.startMessage();
        readTheCommand();
    }

    public void readTheCommand() {

        String userCommand = consoleView.waitingForNextCommand(console.getCurrDir());
        String nameOfCommand = null;

        do {
            while (!checkCommand(userCommand)) {
                consoleView.wrongCommandInfo();
                userCommand = consoleView.waitingForNextCommand(console.getCurrDir());
            }

            String[] splitedCommand = userCommand.split(" ");
            nameOfCommand = splitedCommand[0];

            String[] nextValues = null;

            if (splitedCommand.length > 1) {
                nextValues = new String[splitedCommand.length - 1];
                System.arraycopy(splitedCommand, 1, nextValues, 0, nextValues.length);
            }

            switch (nameOfCommand) {
                case "pvm":
                    System.out.println(pvm());
                    userCommand = consoleView.waitingForNextCommand(console.getCurrDir());
                    break;
                case "ls":
                    System.out.println(ls());
                    userCommand = consoleView.waitingForNextCommand(console.getCurrDir());
                    break;
                case "cd":
                    cd(nextValues);
                    break;
                case "mkdir":
                    mkdir(nextValues);
                    break;
                case "touch":
                    touch(nextValues);
                    break;
                case "cp":
                    cp(nextValues);
                    break;
                case "mv":
                    mv(nextValues);
                    break;
                case "rm":
                    rm(nextValues);
                    break;
                case "tree":
                    tree();
                    break;
                case "help":
                    help();
                    break;
                case "quit":
                    return;
                default:
                    consoleView.wrongCommandInfo();
                    consoleView.waitingForNextCommand(console.getCurrDir());
            }
        } while (!nameOfCommand.equals("quit"));

    }

    private boolean checkCommand(String userCommand) {
        return (!userCommand.equals(null)
                && userCommand.length() >= 1 &&
                (userCommand.charAt(0) >= 'a' && userCommand.charAt(0) <= 'z'));
    }


    @Override
    public String pvm() {
        return console.getCurrDir().getAbsolutePath();
    }

    @Override
    public String ls() {
        StringBuilder stringBuilder = new StringBuilder();
        String[] list = console.getCurrDir().list();

        for (String s : list) {
            stringBuilder.append("\n" + s);
        }
        return stringBuilder.toString();

    }


    @Override
    public void cd(String[] nextValues) {

        String[] argumentsAfterCommand = nextValues;

        if (argumentsAfterCommand == null || argumentsAfterCommand.length >=2){
            consoleView.wrongInputCd();
            return;
        }

        String directoryToChange = argumentsAfterCommand[0];

        switch (directoryToChange) {
            case "/":
                console.setCurrDir(new File(console.getDefaultPath()));
                break;
            case "..":
                String parentPath = console.getCurrDir().getParent();
                if (parentPath.equals(null)) {
                    consoleView.noSuchDirectory();
                    return;
                }

        }

    }

    @Override
    public void mkdir(String[] nextValues) {

    }

    @Override
    public void touch(String[] nextValues) {

    }

    @Override
    public void cp(String[] nextValues) {

    }

    @Override
    public void mv(String[] nextValues) {

    }

    @Override
    public void rm(String[] nextValues) {

    }

    @Override
    public String tree() {
        return null;
    }

    @Override
    public String help() {
        return null;
    }


}

