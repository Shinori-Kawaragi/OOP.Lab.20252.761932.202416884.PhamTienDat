package hust.dsai.soict.aims.exception;

public class PlayerException extends AimsException {
    public PlayerException(String message){
        super(message);
    }
    public String getErrorTitle() {
        return "Có lỗi phát sinh khi xem trước";
    }
}
