package week5.console.view;

import java.io.File;
import java.util.Scanner;

/**
 * Created by SmooZzzie on 18.05.2017.
 */
public class ConsoleView {

    private Scanner scanner = new Scanner(System.in);

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

    public void noSuchDirectory() {
        System.out.println("There isn't such directory!");
    }

}
