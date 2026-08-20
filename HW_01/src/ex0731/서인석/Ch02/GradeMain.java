package ex0731.서인석.Ch02;

import java.util.Scanner;

// Entry
class GradeMain {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        /*아래의 요구사항을 바탕으로 성적 프로그램을 작성해주세요. (ver2)*/

        /*성적프로그램 ver2
        : 성적프로그램이 계속 반복한다. while(true)
        : 1. 성적표구하기     2. 종료 라는 메뉴를 만든다.
        그리고 그 메뉴에 따라 기능을 실행한다.*/

        /* : 메인 메소드를 가지고 있는 클래스는 따로 만든다.

            - 메인 메소드안에서 메뉴를 출력하고 메뉴 선택(1. 성적표구하기     2. 종료 )에 따라
             성적표를 구하거나 종료를한다.
                1번 메뉴를 선택하면 이름, 국어,영어,수학 점수를 키보드로 입력받는다.
                2번 메뉴를 선택하면 프로그램을 종료한다.
        */
        System.out.println("---------------------");
        System.out.println("1.성적표구하기 | 2.종료");
        System.out.println("---------------------");

        Grade grade = new Grade();

        while (true) {
            System.out.print("선택 >");
            String line = sc.nextLine();
            int menu = Integer.parseInt(line.trim());

            if (menu == 1) {
                System.out.print("이름 : ");
                String name = sc.nextLine();

                System.out.print("국어 점수 : ");
                int kor = Integer.parseInt(sc.nextLine().trim());

                System.out.print("영어 점수 : ");
                int eng = Integer.parseInt(sc.nextLine().trim());

                System.out.print("수학 점수 : ");
                int mat = Integer.parseInt(sc.nextLine().trim());

                grade.printGradeReport(name, kor, eng, mat);
            }
            else if (menu == 2) {
                System.out.println("프로그램을 종료합니다");
                break;
            }
            else System.out.println("해당 메뉴가 없습니다. 다시 선택해 주세요");
        }

    }
}

//  Service 로직
class Grade {
    /*성적구하는 기능을 담당하는 클래스
        1) 국어, 영어, 수학 점수를 인수받아 총점을 구하여
        총점을 리턴하는 메소드 작성
                (접근제한자 private)*/

    /* 1. 총점 구하기
    * @param : kor, eng, mat
    * @return : kor + eng + mat 리턴
    * */
    private int getTotalScore(int kor, int eng, int mat) {
        int total = kor + eng + mat;
        System.out.println("\n총점 : " + total);

        return total;
    }


    /* 2) 총점과 과목수(int) 를 인수로받아 평균을 구하여
    평균을 리턴하는 메소드 작성 (접근제한자 private)*/

    /*2. 평균 구하기
    * @param : total, subjectCount
    * @return : avg
    * */
    private double getAverageScore(int total, int subjectCount) {
        double avg = Math.round((double) (total / subjectCount) * 100) / 100.0;
        System.out.println("평균 : " + avg);
        return avg;
    }


   /*3) 평균을 인수로 받아 등급을 구하여 등급을 리턴해주는
    메소드 작성한다(접근제한자 private)*/

    /* 3. 등급 구하기
    * @param : avg -> A ~ F
    * @return : grade
    * */
    private char getGradeScore(double avg) {
        char grade;

        if(avg >= 90) grade = 'A';
        else if(avg >= 80) grade = 'B';
        else if(avg >= 70) grade = 'C';
        else if(avg >= 60) grade = 'D';
        else grade = 'F';

        return grade;
    }

    /*4) 이름, 국어, 영어, 수학 점수를 인수로 받아
    총점 , 평균 ,등급 을 구하여 그 결과를 화면에 출력하는
    메소드를 선언하세요.
    (접근제한자 public,
    총점과 평균 , 등급은 이미 만들어진 1) , 2) ,3) 메소드를 호출
    하여 그 결과를 통해 얻어온다) */

    public void printGradeReport(String name, int kor, int eng, int mat) {

        int total = getTotalScore(kor, eng, mat);
        double avg = getAverageScore(total, 3);
        char grade = getGradeScore(avg);

        System.out.println("\n이름 : " + name);
        System.out.println("총점 : " + total);
        System.out.println("평균 : " + avg);
        System.out.println("학점 : " + grade);
    }
}