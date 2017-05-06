package exceptions;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class MyIndexOutOfBoundException extends RuntimeException{

    public MyIndexOutOfBoundException() {
    }

    public MyIndexOutOfBoundException(String message) {
        super(message);
    }
}
