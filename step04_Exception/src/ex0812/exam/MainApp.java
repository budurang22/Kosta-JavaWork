package ex0812.exam;

import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        ShoppingMall mall = new ShoppingMall();

        // 난수발생 전용 클래스
        Random r = new Random();

        for (int i = 0; i < 10; i++) {
            int age = r.nextInt(55) + 1;// 난수 발생
            try {
                mall.age(age);
            } catch (NoKidsException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }

        System.out.println("예외 개수 = " + NoKidsException.count);
    }
}
