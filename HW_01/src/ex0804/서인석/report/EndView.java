package ex0804.서인석.report;

/*
* 사용자 요청에 대한 최종 결과를
* 모니터에 출력하는 기능을 담당하는 클래스
* */
public class EndView {
    /*
    * 전체 학생의 정보 모니터에 출력
    * */

    public static void printSelectAll(Student[] students) {
        System.out.printf("***** 학생의 정보 (%d)명 *****%n", StudentService.count);

        for (int i = 0; i < StudentService.count; i++) {
            System.out.printf(
                    "이름 : %s | 나이 : %d | 주소 : %s%n",
                    students[i].getName(),
                    students[i].getAge(),
                    students[i].getAddr()
            );
        }
    }
    /*
    * 이름에 해당하는 학생정보 출력
    * */
    public static void printSelectByName(Student studentInfo) {
        System.out.printf("%s님의 기본정보 ", studentInfo.getName());
        System.out.printf("나이 : %d | 주소 : %s%n",
                studentInfo.getAge(), studentInfo.getAddr() );
    }

    /*
    * 성공 or 실패에 대한 메세지를 출력
    * */
    public static void printMessage(String message) {
        System.out.println(message);
    }
}