package ex0812;

public class ExceptionReturnExam {

    public void aa(int i) {
        try {
            if (i == 0) {
                // return; // 메소드 빠져나가라
                System.exit(0); //프로그램 강제종료
            }
            System.out.println(i + "입니다");
        } finally {
            System.out.println("--- aa 종료 ---");
        }
    }

    public static void main(String[] args) {
        System.out.println("*** 메인시작 ***");
        //new ExceptionReturnExam().aa(10);
        new ExceptionReturnExam().aa(0);

        System.out.println("*** 메인종료 ***");

    }
}
