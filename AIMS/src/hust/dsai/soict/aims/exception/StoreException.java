package hust.dsai.soict.aims.exception;

public class StoreException extends AimsException {
    public StoreException(String message) {
        super(message);
    }
    public String getErrorTitle() {
        return "Có lỗi phát sinh tại Store";
    }
}
