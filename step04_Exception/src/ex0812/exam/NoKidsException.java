package ex0812.exam;
/*
* 나이가 18보다 작을때 발생시킬 예외 클래스
* */
public class NoKidsException extends Exception {

    static int count;
    public NoKidsException() {
        super("애들은가라");
        count++;
    }

    public NoKidsException(String message) {
        super(message);
        count++;
    }
}
