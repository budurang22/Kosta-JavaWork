package ex0807.ch07.sec03.exam02;

public class SmartPhoneExam {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("아이폰 17 pro", "블랙");

        System.out.println("모델 : " + myPhone.model);
        System.out.println("색상 : " + myPhone.color);
    }
}
