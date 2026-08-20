package ex0812.ch11.서인석;

/*
 * 5. 메소드가 다음과 같이 선언되어 있습니다. 잘못된 예외 처리르 선택하세요.
 *  publiv void method1() throws NumberFormatException, ClassNotForFoundException{ ... }
 *
 *  1) try { method1(); } catch (Exception e) {}
 *  2) void method2 throws Exception { method1(); }
 *  3) try { method1(); } catch (Exception e) {} catch (ClassNotFoundException e) {}
 *  4) try { method1(); } catch (ClassNotFoundException e) {} catch (NumberFormatException e) {}
 *
 *  정답 : 3번 -> Exception 은 모든 예외를 처리하겠다라는 뜻이므로 다음 catch 블록이 실행되지 않음 -> 필요없다는 뜻
 * */


public class Exam05 {
}
