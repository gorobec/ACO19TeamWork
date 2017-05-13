package design_patterns.dao_mvc.controller;

import design_patterns.dao_mvc.dao.UserDao;
import design_patterns.dao_mvc.model.User;
import design_patterns.dao_mvc.view.ConsoleView;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class UserConsoleControllerTest {

    private  UserConsoleController controller;

    private  UserDao mockUserDao = Mockito.mock(UserDao.class);

    private  ConsoleView mockConsoleView = Mockito.mock(ConsoleView.class);


    @Before
    public void setUp(){
        controller = new UserConsoleController(mockConsoleView, mockUserDao);
    }


    @Test
    public void testAddUser(){

        when(mockConsoleView.enterName()).thenReturn("Yevhen");
        when(mockConsoleView.enterSurname()).thenReturn("Vorobiei");
        when(mockConsoleView.enterAge()).thenReturn("29");
        when(mockConsoleView.enterPhone()).thenReturn("555555");

        when(mockUserDao.addUser(any(User.class))).thenReturn(true);

        assertTrue(controller.addUser());
        verify(mockConsoleView, times(1)).successfulAddOperation();

    }
}
