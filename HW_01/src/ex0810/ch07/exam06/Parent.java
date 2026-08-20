package ex0810.ch07.exam06;

/*
 * 6. Parent 클래스를 상속해서 Child 다음과 같이 작성했는데, Child 생성자에서 컴파일 에러가 발생했습니다.
 * 그 이유와 해결 방법을 설명해 보세요.
 *
 * 정답 : 자식클래스의 생성자 매개변수 2개가 부모 클래스에서 기본생성자를 불러야하는데 없음(컴파일할 때 super())
 *  부모 클래스에 기본생성자 생성 or 자식생성자에 super(name); 을 명시적으로 구현
 * */
public class Parent {
    public String name;

    public Parent(String name) {
        this.name = name;
    }
}
