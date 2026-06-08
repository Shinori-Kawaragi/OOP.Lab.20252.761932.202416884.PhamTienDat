package hust.dsai.soict.aims.exception;

public class WrongInputException extends AimsException {
    public WrongInputException(String message) {
        super(message);
    }
    public String getErrorTitle() {
        return "Có lỗi phát sinh khi tạo đối tượng";
    }
}
