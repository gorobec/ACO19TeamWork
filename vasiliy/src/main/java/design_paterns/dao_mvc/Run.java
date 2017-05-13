package design_paterns.dao_mvc;

import design_paterns.dao_mvc.controllers.UserConsoleController;
import design_paterns.dao_mvc.dao.StaticUserDaoImpl;
import design_paterns.dao_mvc.dao.UserDao;
import design_paterns.dao_mvc.view.ConsoleView;

public class Run {
    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        UserDao dao = new StaticUserDaoImpl();
        UserConsoleController controller = new UserConsoleController(view, dao);

        controller.addUser();
        controller.removeUser();
        controller.removeUser();
    }
}
