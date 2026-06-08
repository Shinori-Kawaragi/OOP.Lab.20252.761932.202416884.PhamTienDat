package hust.dsai.soict.aims.exception;

public class CDException extends AimsException {
    public CDException(String message) {
        super(message);
    }
    public String getErrorTitle() {
        return "Có lỗi phát sinh tại CD";
    }
}
