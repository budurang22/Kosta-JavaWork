package ex0807.ch07.sec07.exam03;

public class ChildExample {
    public static void main(String[] args) {
        // 객체 생성 및 자동 타입변환
        Parent parent = new Child();

        // Parent 타입으로 필드와 메소드 사용
        parent.field = "data1";
        parent.method1();
        parent.method2();

        // parent.field2 = "data2"; // 부모로 자동타입변환 되어서 부모의 필드와 메서드만 사용가능
        // parent.method3();

        // 자식 클래스에 부모 클래스 강제 타입변환
        Child child = (Child) parent;

        child.field = "data";
        child.method03();
    }
}
