package design_patterns.dao_mvc.controller;

import design_patterns.dao_mvc.dao.UserDao;
import design_patterns.dao_mvc.exceptions.AgeValidationException;
import design_patterns.dao_mvc.exceptions.NameValidationException;
import design_patterns.dao_mvc.exceptions.PhoneValidationException;
import design_patterns.dao_mvc.model.User;
import design_patterns.dao_mvc.view.ConsoleView;

import javax.xml.bind.ValidationException;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class UserConsoleController {


    private ConsoleView view;
    private UserDao dao;

    /*public UserConsoleController() {
    }*/

    public UserConsoleController(ConsoleView view, UserDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public boolean removeUser(){

        User user = getUser();

        User result = dao.removeUser(user);

        if(result != null){
            view.successfulRemoveOperation();
        } else {
            view.unsuccessfulRemoveOperation();
        }
        return result != null;
    }

    public boolean addUser(){

        User user = getUser();

        boolean result = dao.addUser(user);

        if(result){
            view.successfulAddOperation();
        } else {
            view.unsuccessfulAddOperation();
        }
        return result;
    }

    private User getUser() {
        String name = view.enterName();
        String surname = view.enterSurname();
        int age = Integer.parseInt(view.enterAge());
        String phoneNumber = view.enterPhone();

        try {
            return new User(name, surname, age, phoneNumber);
        } catch (ValidationException e) {
            view.exceptionMessenger(e);
            return getUser();
        }
    }

}
