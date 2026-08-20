package ex0810.ch07.exam08;

public class SnowTireExample {
    public static void main(String[] args) {
        SnowTire snowTire = new SnowTire();
        Tire tire = snowTire;

        // 재정의(Overriding)된 메소드를 무조건 호출함
        snowTire.run();
        tire.run();
    }
}
