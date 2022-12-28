package Com.Exception;

public class NotFoundAlertException extends RuntimeException{
    public NotFoundAlertException(String message) {
        super(message);
    }
}
