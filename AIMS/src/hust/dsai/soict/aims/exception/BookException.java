package hust.dsai.soict.aims.exception;

public class BookException extends AimsException {
    public BookException(String message) {
        super(message);
    }
    public String getErrorTitle(){
        return "Có lỗi phát sinh tại Book";
    }
}