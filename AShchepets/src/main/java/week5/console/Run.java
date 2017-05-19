package week5.console;

import week5.console.exceptions.MyConsoleInputWrongException;
import week5.console.model.MyConsole;

import java.util.Scanner;

/**
 * Created by SmooZzzie on 17.05.2017.
 */
public class Run {

    public static void main(String[] args) {
        MyConsole console = new MyConsole();

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        String[] splitChoice = choice.split(" ");
        try {
            console.readTheCommand(splitChoice);
        } catch (MyConsoleInputWrongException e) {
            e.getMessage();
            
        }
    }
}
