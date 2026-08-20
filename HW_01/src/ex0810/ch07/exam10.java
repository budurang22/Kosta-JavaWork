package ex0810.ch07;

/*
* 10. 컴파일 에러 이유
* */
public class exam10 {
    public abstract class Machine {
        public void powerOn() {}
        public void powerOff() {}
        public abstract void work();
    }

    public class Computer extends Machine {
        /* 추상화 관련 문제 -> work(); 를 자식클래스에서 오버라이딩 해줘야함
        * 오버라이딩 안할시 클래스가 abstract라서 상속이 안됨
        * */

        @Override
        public void work() {
            System.out.println("abstract overriding");
        }
    }
}
