package ex0812.ch11.서인석.exam07;

public class NotExistIDException extends Exception {
    public NotExistIDException() {
        super("아이디가 존재하지 않습니다.");
    }

    public NotExistIDException(String message) {
       super(message);
    }
}
