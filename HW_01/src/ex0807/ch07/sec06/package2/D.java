package ex0807.ch07.sec06.package2;

import ex0807.ch07.sec06.package1.A;

public class D extends A {
    public D() {
        super(); // A를 호출
    }

    // method1은 상속 되어서 사용 가능
    public void method1() {
        this.field = "value";
        this.method();
    }

//    public void method2() {
//        A a = new A(); // 객체를 생성해서 사용하는 것은 안됨
//        this.field = "value";
//        this.method();
//    }
}
