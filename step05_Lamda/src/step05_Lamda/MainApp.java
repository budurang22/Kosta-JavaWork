package step05_Lamda;

public class MainApp {
    public static void main(String[] args) {
        // 1. 기존방식
        // AInterface ai = new Test();
        // ai.aa();

        // 2.익명의 이너클래스(AnonymouseInterface) 타입
        /*AInterface ai = new AInterface() {
            @Override
            public void aa() {
                System.out.println("익명의 이너클래스(AnonymouseInterface)  aa호출");
            }
        }; // AIenterface end*/

        /*
        * 3. 람다식
        *  : 반드시 interface안에 메소드 한개 있을 경우에 사용 할 수 있다.
        *  문법
        *   1) 인수가 없는 경우
        *   () -> {}
        *
        *   2) 인수가 있는경우
        *   (변수이름, ..) -> {}
        *
        *   3) 기능이 한문장인경우
        *   () -> {}
        * */
        AInterface ai = () -> System.out.println("인수 없는 람다식");
        ai.aa();
        /// ////////////////////////////////////////////////////
        BInterface bi = (a) -> System.out.println(a + "이 전달된 람다식");
        bi.bb(10);
        /// ////////////////////////////////////////////////////
        CInterface ci = (a, b) -> a + b;
        
        int result = ci.cc(15, 20);
        System.out.println("result = " + result);;
        
    }
}

class Test implements AInterface {
    @Override
    public void aa() {
        System.out.println("Test의 aa메소드");
    }
}