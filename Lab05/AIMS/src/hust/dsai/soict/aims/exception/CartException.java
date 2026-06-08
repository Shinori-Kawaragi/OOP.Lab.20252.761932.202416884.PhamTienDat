package hust.dsai.soict.aims.exception;

public class CartException extends AimsException {
    public CartException(String string) {
        super(string);
    }
    public String getErrorTitle(){
        return "Có lỗi phát sinh tại Cart";
    }
}