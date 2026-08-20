package ex0812;

public class ThrowsException {

    public void aa(int i) throws ArithmeticException{
        System.out.println("aa 시작");
        try {
            this.bb(i);
        } finally {
            System.out.println("aa 종료");
        }
    }
    public void bb(int i) throws ArithmeticException {
        System.out.println("bb 시작");
        try {
            int result = 100 / i; // ArithmeticException 가능성
            System.out.println("나눈 결과 = " + result);
        } finally {
            System.out.println("bb 종료");
        }
    }

    public static void main(String[] args) /*throws ArithmeticException*/ {
        System.out.println("*** 메인 시작 ***");

        ThrowsException te = new ThrowsException();
        try {
            te.aa(0);
        } catch (ArithmeticException e) {
            System.out.println("메인에서 예외처리");
            // e.printStackTrace();
        }

        System.out.println("*** 메인 종료 ***");
    }
}
