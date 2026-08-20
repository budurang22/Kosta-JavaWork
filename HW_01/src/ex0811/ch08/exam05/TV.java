package ex0811.ch08.exam05;

/*
* 5. TV 클래스를 실행했을 때 "TV를 켰습니다."라고 출력되도록 밑줄과 박스에 들어갈 코드를 작성하세요.
* 밑줄 : implements Remocon
* 박스 :
* */
public class TV implements Remocon {
    @Override
    public void powerOn() {
        System.out.println("TV를 켰습니다");
    }

    public static void main(String[] args) {
        Remocon r = new TV();
        r.powerOn();
    }
}
