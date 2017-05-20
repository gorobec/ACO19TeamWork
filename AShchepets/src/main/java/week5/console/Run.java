package week5.console;

import week5.console.controller.ConsoleControllerImpIConsole;
import week5.console.model.MyConsole;
import week5.console.view.ConsoleView;

import java.io.IOException;

/**
 * Created by SmooZzzie on 17.05.2017.
 */
public class Run {

    public static void main(String[] args) throws IOException {

        ConsoleView consoleView = new ConsoleView();
        ConsoleControllerImpIConsole consoleController = new ConsoleControllerImpIConsole(consoleView,new MyConsole());

        consoleController.startWorking();
    }
}
