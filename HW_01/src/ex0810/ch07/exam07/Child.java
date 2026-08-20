package ex0810.ch07.exam07;

public class Child extends Parent {
    public String name;

    public Child (){
        // super(); // 이게 생략되어 있어서 부모 클래스의 기본 생성자로 이동
        this("홍길동");
        System.out.println("Child() call");
    };

    public Child(String name) {
        this.name = name;
        System.out.println("Child(String name) call");
    }
}
