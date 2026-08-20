package ex0730.서인석.ch01;

import java.util.Scanner;

public class Page140 {
    public static void main(String[] args) {
        /* 1. 1번 -> 위에서 아래로 순차적으로 계산하기 때문에 흐름을 바꿀 순 없다 */

        /* 2. 왼쪽 switch 문을 Expression(표현식)으로 변경하기 */
        String grade = "B";

        int score1 = switch(grade) {
            case "A" -> 100;
            case "B" -> 100 - 20;
            default -> 60;
        };

        /* 3. for문 = 1 ~ 100 까지의 3의 배수 구하기 */
        for(int i=1; i<=100; i++) {
            if(i%3==0) {
                System.out.print(i + "\t");
            }
        }
        System.out.println("\n");
        /* 4. 주사위 눈의 합이 5가 되면 멈추는 코드 작성 */
        while(true) {
            int a = (int)(Math.random() * 6 + 1);
            int b = (int)(Math.random() * 6 + 1);

            System.out.print("(" + a + ", " + b + ")");
            if(a + b == 5) break;
        }

        System.out.println("\n");
        /* 5. 중첩 for문 이용하여 방정식 4x + 5y = 60의 모든 해를 구해서 (x, y) 형태로 출력. 단, x y는 10 이하의 자연수 */

        System.out.println("\n");
        /* 6. 별 찍기 */
        for(int i=1; i<=6; i++){
            for(int j=0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("\n");

        /* 7. whlie문과 scanner의 nextLine() 메소드 활용해서 문제 풀기 */
        Scanner sc = new Scanner(System.in);
        int balance = 0;

        System.out.println("------------------------------");
        System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
        System.out.println("------------------------------\n");


        while(true) {
            System.out.println("선택>\t");
            int menu = sc.nextInt();


            if(menu == 1) {
                System.out.println("예금액> ");
                int money = sc.nextInt();
                balance += money;
                System.out.println(balance + "원 예금하였습니다.");
            } else if (menu == 2) {
                System.out.println("출금액> ");
                int money = sc.nextInt();
                balance -= money;
                System.out.println(balance + "원 출금하였습니다.");
            } else if (menu == 3 ){
                System.out.println("잔고는 " + balance + "원 입니다.");
            } else if (menu == 4) {
                break;
            } else {
                System.out.println("없는 메뉴 입니다. 다시 시도해 주세요");
            }
        }
        System.out.println("안녕히 가세요.");
    }
}
