package design_paterns.dao_mvc.controllers;

import design_paterns.dao_mvc.Model.User;
import design_paterns.dao_mvc.dao.UserDao;
import design_paterns.dao_mvc.view.ConsoleView;

public class UserConsoleController {
    private ConsoleView view;
    private UserDao dao;

    public UserConsoleController(ConsoleView view, UserDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public boolean addUser(){
        User user = getUser();

        boolean result = dao.addUser(user);
        if (result){
            view.successfulAddOperation();
        } else {
            view.unsuccessfulAddOperation();
        }

        return result;
    }

    public boolean removeUser(){
        User user = getUser();

        User result = dao.removeUser(user);
        if (result!=null){
            view.successfulRemoveOperation();
        } else {
            view.unsuccessfulRemoveOperation();
        }

        return result!=null;
    }

    private User getUser() {
        String name = view.enterName();
        String surname = view.enterSurname();
        int age = Integer.parseInt(view.enterAge());
        String phoneNumber = view.enterPhone();

        return new User(name, surname, age, phoneNumber);
    }
}
