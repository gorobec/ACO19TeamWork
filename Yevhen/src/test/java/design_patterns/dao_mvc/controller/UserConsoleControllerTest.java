package design_patterns.dao_mvc.controller;

import design_patterns.dao_mvc.dao.UserDao;
import design_patterns.dao_mvc.model.User;
import design_patterns.dao_mvc.view.ConsoleView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.xml.bind.ValidationException;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
@RunWith(MockitoJUnitRunner.class)
public class UserConsoleControllerTest {


    @InjectMocks
    private  UserConsoleController controller;
    @Mock
    private  UserDao mockUserDao;
    @Mock
    private  ConsoleView mockConsoleView;

    @Test
    public void testAddUser() throws ValidationException {

        User user = new User("Yevhen", "Vorobiei", 29, "1234567890");

        when(mockConsoleView.enterName()).thenReturn(user.getName());
        when(mockConsoleView.enterSurname()).thenReturn(user.getSurname());
        when(mockConsoleView.enterAge()).thenReturn(String.valueOf(user.getAge()));
        when(mockConsoleView.enterPhone()).thenReturn(user.getPhoneNumber());

        when(mockUserDao.addUser(eq(user))).thenReturn(true);

        assertTrue(controller.addUser());
        verify(mockConsoleView, times(1)).successfulAddOperation();

    }

    @Test
    public void testAddUserValidationException() throws ValidationException {

        User user = new User("Yevhen", "Vorobiei", 29, "1234567890");

        when(mockConsoleView.enterName()).thenReturn(user.getName());
        when(mockConsoleView.enterName()).thenReturn("sdsds");
        when(mockConsoleView.enterSurname()).thenReturn(user.getSurname());
        when(mockConsoleView.enterAge()).thenReturn(String.valueOf(user.getAge()));
        when(mockConsoleView.enterPhone()).thenReturn(user.getPhoneNumber());


        when(mockUserDao.addUser(eq(user))).thenReturn(true);

        assertTrue(controller.addUser());
        verify(mockConsoleView, times(1)).successfulAddOperation();

    }
}
