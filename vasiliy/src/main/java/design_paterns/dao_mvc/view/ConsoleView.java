package design_paterns.dao_mvc.view;

import java.util.Scanner;

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

    public String enterAge(){
        System.out.print("Enter user's age: ");
        return scanner.nextLine();
    }

    public String enterPhone(){
        System.out.print("Enter user's phone: ");
        return scanner.nextLine();
    }

    public void start(){
        System.out.println("Welcome to the users contact list");
    }

    public void successfulAddOperation(){
        System.out.println("User was added successfully.");
    }

    public void unsuccessfulAddOperation(){
        System.out.println("User was not added successfully.");
    }

    public void successfulRemoveOperation(){
        System.out.println("User was removed successfully.");
    }

    public void unsuccessfulRemoveOperation(){
        System.out.println("User was not removed successfully.");
    }
}
