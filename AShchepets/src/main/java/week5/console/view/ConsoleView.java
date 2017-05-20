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

        System.out.print(new StringBuilder("\033[30;01m").append(currDir.getAbsolutePath()).append(">"));

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
        StringBuilder stringBuilder = new StringBuilder("\033[32;01m");

        for (String s : list) {
            stringBuilder.append("\n-").append(s);
        }

        return stringBuilder.toString();
    }

    public void mkDirWrongResult() {
        System.out.println("Error. The directory wasn't created.");
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

    public String pvmOutput(File currDir) {
        return "\033[32;01m" + currDir.getAbsolutePath();
    }

    public void printDirectoryTree(File currDir, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent));
        sb.append("+--");
        sb.append(currDir.getName());
        sb.append("/");
        sb.append("\n");
        if (currDir.list() != null) {
            for (File file : currDir.listFiles()) {
                if (file.isDirectory()) {
                    printDirectoryTree(file, indent + 1, sb);
                } else {
                    printFile(file, indent + 1, sb);
                }
            }
        }
    }

    public String getIndentString(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("|  ");
        }
        return sb.toString();
    }


    private void printFile(File file, int indent, StringBuilder sb) {
        sb.append(getIndentString(indent));
        sb.append("+--");
        sb.append(file.getName());
        sb.append("\n");
    }
}
