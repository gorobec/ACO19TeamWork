package design_patterns.dao_mvc.utils;

import design_patterns.dao_mvc.exceptions.AgeValidationException;
import design_patterns.dao_mvc.exceptions.NameValidationException;
import design_patterns.dao_mvc.exceptions.PhoneValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Validation {
    private static final String NAME_PATTERN = "[A-Z][a-z]{2,15}";
    private static final String AGE_PATTERN = "^(0?[1-9]|[1-9][0-9])$";
    private static final String PHONE_PATTERN = "\\d{10}";

    public static void validateNameSurname(String name) throws NameValidationException {
        if(!isMatch(NAME_PATTERN, name)){
            throw new NameValidationException("Name and surname should contains only A-Z a-z, length 2 -15");
        }
    }

    public static void validateAge(int age) throws AgeValidationException {

        if(!isMatch(AGE_PATTERN, String.valueOf(age))){
            throw new AgeValidationException("Age should cbe from 1 to 99");
        }
    }

    public static void validatePhoneNumber(String phoneNumber) throws PhoneValidationException {

        if(!isMatch(PHONE_PATTERN, phoneNumber)){

            throw new PhoneValidationException("Phone should contains only 10 digits");
        }
    }

    private static boolean isMatch(String regEx, String value) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
