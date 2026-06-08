package hust.dsai.soict.aims.exception;

public class DVDException extends AimsException {
    public DVDException(String message) {
        super(message);
    }
    public String getErrorTitle() {
        return "Có lỗi phát sinh tại DVD";
    }
}
