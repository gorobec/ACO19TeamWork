package week5.console.controller;

import week5.console.model.MyConsole;
import week5.console.view.ConsoleView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by SmooZzzie on 18.05.2017.
 */
public class ConsoleControllerImpIConsole implements IConsoleController {

    private ConsoleView consoleView;
    private MyConsole console;

    public ConsoleControllerImpIConsole(ConsoleView consoleView, MyConsole console) {
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
                    userCommand = consoleView.waitingForNextCommand(console.getCurrDir());
                    break;
                case "mkdir":
                    mkdir(nextValues);
                    userCommand = consoleView.waitingForNextCommand(console.getCurrDir());
                    break;
                case "touch":
                    touch(nextValues);
                    userCommand = consoleView.waitingForNextCommand(console.getCurrDir());
                    break;
                case "cp":
                    cp(nextValues);
                    userCommand = consoleView.waitingForNextCommand(console.getCurrDir());
                    break;
                case "mv":
                    mv(nextValues);
                    userCommand = consoleView.waitingForNextCommand(console.getCurrDir());
                    break;
                case "rm":
                    rm(nextValues);
                    userCommand = consoleView.waitingForNextCommand(console.getCurrDir());
                    break;
                case "tree":
                    tree();
                    userCommand = consoleView.waitingForNextCommand(console.getCurrDir());
                    break;
                case "help":
                    System.out.println(help());
                    userCommand = consoleView.waitingForNextCommand(console.getCurrDir());
                    break;
                case "quit":
                    return;
                default:
                    consoleView.wrongCommandInfo();
                    userCommand = consoleView.waitingForNextCommand(console.getCurrDir());
            }
        } while (!nameOfCommand.equals("quit"));

    }

    private boolean checkCommand(String userCommand) {
        return ((userCommand != null)
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

        return consoleView.viewList(list);

    }


    @Override
    public void cd(String[] nextValues) {

        String[] argumentsAfterCommand = nextValues;

        if (!checkArguments(argumentsAfterCommand, 1)) return;


        String directoryToChange = argumentsAfterCommand[0];
        String parentPath = console.getCurrDir().getParent();
        String[] listOfChildren = console.getCurrDir().list();

        if (directoryToChange != null && containsDir(listOfChildren, directoryToChange)) {
            File newCurrDir = new File(directoryToChange);
            console.setCurrDir(newCurrDir);
        } else {
            switch (directoryToChange) {
                case "/":
                    console.setCurrDir(new File(console.getDefaultPath()));
                    break;
                case "..":
                    if (parentPath == null) {
                        consoleView.noSuchDirectory();
                        return;
                    }
                    console.setCurrDir(new File(parentPath));
                    break;
                case ".":
                    break;
                default:
                    consoleView.wrongInputCd();
                    break;
            }
        }


    }

    private boolean checkArguments(String[] argumentsAfterCommand, int verifiedLength) {
        if (argumentsAfterCommand == null
                || (argumentsAfterCommand.length <= 0 && argumentsAfterCommand.length > verifiedLength)) {
            return false;
        }
        return true;
    }

    private boolean containsDir(String[] listOfChildren, String directoryToFind) {

        String list[] = listOfChildren;
        String directory = directoryToFind;

        File file = new File(directory);

        boolean result = false;

        if (file.isFile()) return result;

        for (int i = 0; i < list.length; i++) {
            if (directory.equals(list[i])) result = true;
        }
        return result;
    }


    @Override
    public void mkdir(String[] nextValues) {
        String[] argumentsAfterCommand = nextValues;

        if (!checkArguments(argumentsAfterCommand, 1)) return;
        String directoryToCreate = argumentsAfterCommand[0];

        File newDir = new File(directoryToCreate);

        if (newDir.mkdir()) consoleView.mkDirResult("");
        else consoleView.mkDirResult("not");
    }

    @Override
    public void touch(String[] nextValues) {

        String[] argumentsAfterCommand = nextValues;
        File curDir = new File(console.getCurrDir().getAbsolutePath());

        if (!checkArguments(argumentsAfterCommand, 1)) return;

        for (int i = 0; i < argumentsAfterCommand.length; i++) {
            File newFile = new File(curDir.getAbsolutePath() + "\\" + nextValues[i]);
        }

    }

    @Override
    public void cp(String[] nextValues) {
        String[] argumentsAfterCommand = nextValues;
        if (!checkArguments(argumentsAfterCommand, 2)) return;

        String copyingFileName = argumentsAfterCommand[0];
        String secondArgument = argumentsAfterCommand[1];

        File currDir = new File(console.getCurrDir().getAbsolutePath());

        if (checkOnFilesAndSameExtension(copyingFileName, secondArgument)) {
            Path source = Paths.get(currDir.getAbsolutePath() + "\\" + copyingFileName);
            Path destination = Paths.get(currDir.getParent() + "\\" + secondArgument);

            try {
                Files.copy(source, destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (checkOnDirToCopy(copyingFileName, secondArgument)) {
            Path source = Paths.get(currDir.getAbsolutePath() + "\\" + copyingFileName);
            Path destination = Paths.get(secondArgument);

            try {
                Files.copy(source, destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            consoleView.wrongInputCp();
        }
    }

    private boolean checkOnDirToCopy(String copyingFileName, String secondArgument) {

        File newFile = new File(console.getCurrDir().getAbsolutePath() + "\\" + copyingFileName);
        File secondArgumentLikeDir = new File(secondArgument);

        if (newFile.exists() && newFile.isFile()) {
            if (secondArgumentLikeDir.exists() && secondArgumentLikeDir.isDirectory()) {
                return true;
            }
            return false;
        } else return false;
    }


    private boolean checkOnFilesAndSameExtension(String copyingFileName, String secondArgument) {

        File newFile = new File(console.getCurrDir().getAbsolutePath() + "\\" + copyingFileName);
        File secondFile = new File(console.getCurrDir().getAbsolutePath() + "\\" + secondArgument);

        if (newFile.exists() && secondFile.exists()) {
            if (newFile.isFile() && secondFile.isFile()) {

                String firstFileExt = newFile.getName().substring(
                        newFile.getName().lastIndexOf("."), newFile.getName().length());
                String secondFileExt = secondFile.getName().substring(
                        secondFile.getName().lastIndexOf("."), secondFile.getName().length());

                if (firstFileExt.equals(secondFileExt)) {
                    return true;
                }
                return false;
            }
            return false;
        } else return false;

    }

    @Override
    public void mv(String[] nextValues) {
        String[] argumentsAfterCommand = nextValues;

        if (!checkArguments(argumentsAfterCommand, 2)) return;

        File fileToMove = new File(console.getCurrDir().getAbsolutePath() + "\\" + argumentsAfterCommand[0]);
        File directoryToMove = new File(argumentsAfterCommand[1]);
        String directoryPathToMove = argumentsAfterCommand[1];
        String parentPath = console.getCurrDir().getParent();

        if (fileToMove.exists() && fileToMove.isFile()) {
            if (directoryToMove.exists() && directoryToMove.isDirectory()) {

            } else {
                switch (directoryPathToMove) {
                    case "/":
                        console.setCurrDir(new File(console.getDefaultPath()));
                        break;
                    case "..":
                        if (parentPath == null) {
                            consoleView.noSuchDirectory();
                            return;
                        }
                        console.setCurrDir(new File(parentPath));
                        break;
                    case ".":
                        break;
                    default:
                        consoleView.wrongInputMv();
                        break;
                }
            }
        } else consoleView.noSuchFileInDir();

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
        return consoleView.viewHelp();
    }


}

