package design_patterns.dao_mvc.model;

import design_patterns.dao_mvc.exceptions.AgeValidationException;
import design_patterns.dao_mvc.exceptions.NameValidationException;
import design_patterns.dao_mvc.exceptions.PhoneValidationException;
import org.junit.Test;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class UserTest {


    @Test (expected = NameValidationException.class)
    public void testUserNameValidation() throws PhoneValidationException, NameValidationException, AgeValidationException {

        User user = new User("asd", "Ahmed", 45, "7897897897");
    }

}
