package ex0807.ch07.sec05.exam02;

public class SportCar extends Car {
    public void speedUp() {
        speed += 10;
    }

//    public void stop() { // 부모 메서드에서 final 사용해서 더이상 오버라이딩 안됨
//        System.out.println("스포츠카를 멈춤");
//        speed = 0;
//    }
}
