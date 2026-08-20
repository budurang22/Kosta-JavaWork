package ex0810.ch07.exam11;

/*
* MainActivity 의 onCreate()를 실행할 때 Activity의 onCreate()도 실행하기
* 정답 : super 키워드를 사용하여 부모의 메소드를 같이 부른후 print 해주기
* */

public class Activity {
    public void onCreate() {
        System.out.println("기본적인 실행 내용");
    }
}
