package Com.Exception;

public class BadRequestAlertException extends RuntimeException{
    public BadRequestAlertException(String message) {
        super(message);
    }
}
