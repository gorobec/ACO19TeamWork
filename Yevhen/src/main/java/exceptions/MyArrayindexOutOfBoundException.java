package exceptions;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class MyArrayindexOutOfBoundException extends Exception {

    public MyArrayindexOutOfBoundException() {
    }

    public MyArrayindexOutOfBoundException(String message) {
        super(message);
    }
}
