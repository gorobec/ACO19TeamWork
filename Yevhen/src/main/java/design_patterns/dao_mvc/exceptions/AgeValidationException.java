package design_patterns.dao_mvc.exceptions;

import javax.xml.bind.ValidationException;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class AgeValidationException extends ValidationException {
    public AgeValidationException(String s) {
        super(s);
    }
}
