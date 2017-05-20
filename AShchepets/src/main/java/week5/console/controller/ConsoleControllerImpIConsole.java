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
                    System.out.println(tree());
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
        return consoleView.pvmOutput(console.getCurrDir());
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


        File directoryToChange = new File(console.getCurrDir().getAbsolutePath() + "\\" + argumentsAfterCommand[0]);
        String parentPath = console.getCurrDir().getParent();
        String[] listOfChildren = console.getCurrDir().list();

        if (directoryToChange != null && containsDir(listOfChildren, directoryToChange)) {
            File newCurrDir = new File(directoryToChange.getAbsolutePath());
            console.setCurrDir(newCurrDir);
        } else {
            switch (directoryToChange.getName()) {
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

    private boolean containsDir(String[] listOfChildren, File directoryToFind) {

        String list[] = listOfChildren;
        File directory = directoryToFind;

        boolean result = false;

        if (directory.isDirectory()) {
            for (int i = 0; i < list.length; i++) {
                if (directory.getName().equals(list[i])) result = true;
            }
        }

        return result;
    }


    @Override
    public void mkdir(String[] nextValues) {
        String[] argumentsAfterCommand = nextValues;

        if (!checkArguments(argumentsAfterCommand, 1)) return;
        String directoryToCreate = argumentsAfterCommand[0];

        File newDir = new File(directoryToCreate);

        if (!newDir.mkdir()) consoleView.mkDirWrongResult();
    }

    @Override
    public void touch(String[] nextValues) {

        String[] argumentsAfterCommand = nextValues;
        File curDir = new File(console.getCurrDir().getAbsolutePath());

        if (!checkArguments(argumentsAfterCommand, 1)) return;

        for (int i = 0; i < argumentsAfterCommand.length; i++) {
            File newFile = new File(curDir.getAbsolutePath() + "\\" + nextValues[i]);

            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void cp(String[] nextValues) {

        String[] argumentsAfterCommand = nextValues;
        if (!checkArguments(argumentsAfterCommand, 2)) return;

        String copyingFileName = argumentsAfterCommand[0];
        String secondArgument = argumentsAfterCommand[1];

        File currDir = new File(console.getCurrDir().getAbsolutePath());

        File source = new File(currDir.getAbsolutePath() + "\\" + copyingFileName);

        if (checkOnFilesAndSameExtension(copyingFileName, secondArgument)) {

            Path destination = Paths.get(currDir.getAbsolutePath() + "\\" + secondArgument);

            try {
                Files.copy(source.toPath(), destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (checkOnDirToCopy(source, secondArgument)) {

            Path destination = Paths.get(secondArgument + "\\" + copyingFileName);

            try {
                Files.copy(source.toPath(), destination);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            consoleView.wrongInputCp();
        }
    }

    private boolean checkOnDirToCopy(File path, String secondArgument) {

        File file = new File(path.getAbsolutePath());
        File secondArgumentLikeDir = new File(secondArgument);

        if (file.exists() && file.isFile()) {
            if (secondArgumentLikeDir.exists() && secondArgumentLikeDir.isDirectory()) {
                return true;
            }
            return false;
        } else return false;
    }


    private boolean checkOnFilesAndSameExtension(String copyingFileName, String secondArgument) {

        File newFile = new File(console.getCurrDir().getAbsolutePath() + "\\" + copyingFileName);
        File secondFile = new File(console.getCurrDir().getAbsolutePath() + "\\" + secondArgument);

        if (newFile.exists()) {
            if (newFile.isFile()) {

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

        Path sourcePath = Paths.get(console.getCurrDir().getAbsolutePath() + "\\" + fileToMove.getName());
        Path destinyPath;

        if (fileToMove.exists() && fileToMove.isFile()) {
            switch (directoryPathToMove) {
                case "..":

                    if (parentPath == null) {
                        consoleView.noSuchDirectory();
                        return;
                    }

                    destinyPath = Paths.get(console.getCurrDir().getParent() + "\\" + fileToMove.getName());

                    try {
                        Files.move(sourcePath, destinyPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
                case ".":
                    destinyPath = Paths.get(console.getCurrDir().getAbsolutePath() + "\\" + fileToMove.getName());

                    try {
                        Files.move(sourcePath, destinyPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
            }
            if (directoryToMove.exists() && directoryToMove.isDirectory()) {

                destinyPath = Paths.get(directoryPathToMove + "\\" + fileToMove.getName());

                try {
                    Files.move(sourcePath, destinyPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else consoleView.wrongInputMv();
        } else consoleView.noSuchFileInDir();
    }


    @Override
    public void rm(String[] nextValues) {

        String[] argumentsAfterCommand = nextValues;

        if (!checkArguments(argumentsAfterCommand, 1)) return;

        File fileToRemove = new File(console.getCurrDir().getAbsolutePath() + "\\" + argumentsAfterCommand[0]);

        if (fileToRemove.exists() && fileToRemove.isFile()) {

            try {
                Files.delete(fileToRemove.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else consoleView.noSuchFileInDir();
    }

    @Override
    public String tree() {

        File currDir = new File(console.getCurrDir().getAbsolutePath());
        if (!currDir.isDirectory()) {
            throw new IllegalArgumentException(" is not a Directory");
        }
        int indent = 0;
        StringBuilder sb = new StringBuilder();
        consoleView.printDirectoryTree(currDir, indent, sb);
        return sb.toString();
    }

    @Override
    public String help() {
        return consoleView.viewHelp();
    }


}

