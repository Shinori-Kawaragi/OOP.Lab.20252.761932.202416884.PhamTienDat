package hust.dsai.soict.aims.exception;

public abstract class AimsException extends Exception {
    public AimsException(String message) {
        super(message);
    }
    public abstract String getErrorTitle();
}