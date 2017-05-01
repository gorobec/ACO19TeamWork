package design_patterns.dao_mvc.view;

import java.util.Scanner;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class ConsoleView {

    private Scanner scanner = new Scanner(System.in);

    public String enterName(){
        System.out.print("Enter user's name: ");
        return scanner.nextLine();
    }

    public String enterSurname(){
        System.out.print("Enter user's surname: ");
        return scanner.nextLine();
    }

    public String enterPhone(){
        System.out.print("Enter user's phone number: ");
        return scanner.nextLine();
    }

    public String enterAge(){
        System.out.print("Enter user's age: ");
        return scanner.nextLine();
    }

    public void start(){
        System.out.println("Welcome to users contact list");
    }

    public void successfulAddOperation(){
        System.out.println("User was added");
    }

    public void successfulRemoveOperation(){
        System.out.println("User was removed");
    }

    public void unsuccessfulAddOperation() {
        System.out.println("User was not added");

    }

    public void unsuccessfulRemoveOperation() {
        System.out.println("User was not removed");
    }
}
