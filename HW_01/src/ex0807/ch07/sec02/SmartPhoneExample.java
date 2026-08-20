package ex0807.ch07.sec02;

public class SmartPhoneExample {
    public static void main(String[] args) {
        // SmartPhone 객체 생성
        SmartPhone myPhone = new SmartPhone("갤럭시", "은색");

        // Phone으로 상속받은 필드 읽기
        System.out.println("model = " + myPhone.model);
        System.out.println("color = " + myPhone.color);

        // SmartPhone 필드 읽기
        System.out.println("와이파이 상태 : " + myPhone.wifi);

        //Phone으로 부터 상속받은 메소드 호출
        myPhone.bell();
        myPhone.sendVoice("여보세요");
        myPhone.receiveVoice("안녕하세요~~");
        myPhone.sendVoice("아 네 반갑습니다");
        myPhone.hangup();

        //SmartPhone으로 부터 상속받은 메소드 호출
        myPhone.setWifi(true);
        myPhone.internet();
    }
}
