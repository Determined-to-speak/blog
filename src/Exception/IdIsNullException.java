package Exception;

/**
 * Created by asus on 2017/8/4.
 */
public class IdIsNullException extends Exception {
    public IdIsNullException() {
    }

    public IdIsNullException(String message) {
        super(message);
    }

    public IdIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdIsNullException(Throwable cause) {
        super(cause);
    }


}
