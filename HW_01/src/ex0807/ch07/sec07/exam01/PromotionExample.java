package ex0807.ch07.sec07.exam01;

class A {
}

class B extends A {
}

class C extends A {
}

class D extends B {
}

class E extends C {
}

public class PromotionExample {
    public static void main(String[] args) {
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();

        A a1 = b;
        A a2 = c;
        A a3 = d;
        A a4 = e;

        B b1 = d;
        C c1 = e;

        // D, E 기준에서 부보는 D의 부모 B, E의 부모 C 이기 때문에 사용 불가
//        B b3 = e;
//        C c2 = d;

    }
}
