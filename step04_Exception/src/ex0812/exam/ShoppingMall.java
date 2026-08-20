package ex0812.exam;

public class ShoppingMall {
    public void age(int age) throws NoKidsException {
        if (age < 18) {
            // 예외발생
            throw new NoKidsException(age + "살 님 입장불가입니다");
            // System.out.println();
        } else {
            System.out.println(age + "살 님 입장하세요");
        }
    }
}
