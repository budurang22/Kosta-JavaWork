package step05_Lamda;

/*
* @FunctionalInterface는 메소드가 한개일 때 선언
* 단, 기능이 있는 default, static 있는 경우데도 쓸 수 있다.
*
* */

@FunctionalInterface
public interface AInterface {
    void aa();
    default void ff() {};
}
