package ex0803.서인석.report;

import java.util.Scanner;

public class Page201_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = 0;
        int max = 0;
        double avg = 0;
        int [] score = null;


        while(true) {
            /*메뉴를 구현한다
            * 1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료
            * while(true)에서 종료 될 때 까지 실행
            * */
            System.out.println("\n============================================");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("==============================================");
            System.out.print("선택 > ");
            /*입력값은 scanner로 정수를 받음(숫자)*/
            int choice = scanner.nextInt();

            /* 1.학생수
            * 메뉴에서 1번 선택 시 조건문으로 이동
            * count라는 변수에 학생수 입력 받기
            * 입력받은 학생수를 score에 배열로 넣기
            * 입력받은 학생 수 만큼 배열 공간 생성 ex) 3 -> 배열 { 0, 1, 2 }
            * */

            /* 2.점수입력
            * 1번 처리가 끝나면 다시 메뉴로 이동
            * for문을 1번에서 입력된 수 만큼 반복 한다
            * 반복하면서 score[i]를 println
            * 입력 받은 값을 score[i]의 값을 넣어줌
            * */

            /* 3.점수리스트
            * 2번 까지 처리 후 메뉴로 다시 이동
            * 저장된 배열의 리스트를 for문으로 출력
            * */

            /* 4.분석
            * 최고점수 : score[i]에 0, 1, 2 for문이 돌면서 2번에서 저장된 값을 max 변수와 비교하면서 if문 실행
            * 평균점수 : score[i]의 값들을 / 3 하여 double 형태로 avg에 저장
            * max, avg 변수 출력
            * */

            /* 5. 종료
            * 5번 입력시 프로그램 종료 문구 출력
            * */

            /* 예외처리 -> 1번 시작을 안할 시 오류 발생
            * 발생한 오류는 if (score = null) 일 때, 다시 메뉴 선택으로 보냄
            * if 빠져나간 후 다시 while에서 돈다
            * */
            if (choice == 1) {
                System.out.print("학생수 > ");
                int count = scanner.nextInt();
                score = new int[count];
            } else if (choice == 2) {
                if (score == null) System.out.println("1번을 입력 후 선택주세요");
                else {
                    for (int i = 0; i < score.length; i++) {
                        System.out.print("score [" + i +"] >");
                        score[i] = scanner.nextInt();
                    }
                }
            } else if (choice == 3) {
                if (score == null) System.out.println("2번을 입력 후 선택해주세요");
                else {
                    for (int i = 0; i < score.length; i++) {
                        System.out.println("score [" + i + "] = " + score[i]);
                    }
                }
            } else if (choice == 4) {
                if (score == null) System.out.println("3번을 입력 후 선택해주세요\n");
                else {
                    for (int i = 0; i < score.length; i++) {
                        if (score[i] > max) {
                            max = score[i];
                        }
                        max += score[i];
                        avg = (double) max / score.length;
                    }
                }
                System.out.println("최고점수 : " + max);
                System.out.println("평균점수 : " + avg);
            } else if (choice == 5) {
                System.out.println("프로그램을 종료합니다");
                break;
            } else {
                System.out.println("잘못된 메뉴 입니다. 다시 선택해주세요");
            }
        }
    }
}
