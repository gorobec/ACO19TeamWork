package week5.console.view;

import java.io.File;
import java.util.Scanner;

/**
 * Created by SmooZzzie on 18.05.2017.
 */
public class ConsoleView {

    private Scanner scanner = new Scanner(System.in);

    public ConsoleView() {
    }

    public void startMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n---------------------------");
        stringBuilder.append("\n----Welcome to the cmd!----");
        stringBuilder.append("\n---------------------------\n");

        System.out.print(stringBuilder);
    }

    public void wrongCommandInfo() {

        System.out.println("Wrong command input! Try again or type \"help\" to call a manual.\n");

    }

    public String waitingForNextCommand(File currDir) {

        System.out.print(new StringBuilder(currDir.getAbsolutePath()).append(">"));

        return scanner.nextLine();
    }

    public void wrongInputCd() {
        System.out.println("Wrong input of \"cd\" command. Try again or type \"help\" if you need and help.");
    }

    public void wrongInputCp() {
        System.out.println("Wrong input of \"cp\" command. Try again or type \"help\" if you need and help.");
    }

    public void noSuchDirectory() {
        System.out.println("There isn't such directory!");
    }

    public void languageProblem(File dir) {
        System.out.println("Sorry, but we couldn't understand what means" + dir + ". Please use only latin letters!");
    }

    public String viewList(String[] list) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : list) {
            stringBuilder.append("\n-").append(s);
        }

        return stringBuilder.toString();
    }

    public void mkDirResult(String s) {
        System.out.println("The directory was " + s + "created!");
    }

    public String viewHelp() {
        // there should be a reference, but i'm laziest guy all over the world
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("I'm so lazy to write it, so... ");

        return stringBuilder.toString();
    }

    public void wrongInputMv() {
        System.out.println("Wrong input of \"mv\" command. Try again or type \"help\" if you need and help.");
    }

    public void noSuchFileInDir() {
        System.out.println("There is no such file in directory!");
    }
}
