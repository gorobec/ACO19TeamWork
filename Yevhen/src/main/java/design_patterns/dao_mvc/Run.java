package design_patterns.dao_mvc;

import design_patterns.dao_mvc.controller.UserConsoleController;
import design_patterns.dao_mvc.dao.StaticUserDaoImpl;
import design_patterns.dao_mvc.dao.UserDao;
import design_patterns.dao_mvc.view.ConsoleView;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
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
