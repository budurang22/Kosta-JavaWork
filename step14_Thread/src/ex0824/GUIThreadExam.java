package ex0824;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class GUIThreadExam extends JFrame { // 창 역할 - Container

    JTextField text1 = new JTextField(5);
    JTextField text2 = new JTextField(5);

    JButton btn1 = new JButton("Button1");
    //
    boolean state = true;


    public GUIThreadExam() {
        super("GUI Thread");

        // JFrame의 레이아웃(배치도) 변경
        super.setLayout(new FlowLayout());

        // component를 JFrame위에 올리기
        Container container = super.getContentPane();

        container.add(btn1);
        container.add(text1);
        container.add(text2);

        // 창 크기조절
        super.setSize(400, 300);
        super.setLocationRelativeTo(null); // 정중앙에 놓기
        // 창 보이기
        super.setVisible(true);

        // x를 클릭했을 때 프로그램 종료
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 스레드 시작
        new NowTimeThread().start(); // 시계
/*
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start(); // 1~1000까지 숫자
*/
        new Thread(() -> {
            // run 메소드 inner
            for (int i = 0; i <= 100; i++) {
                text1.setText(i + "");
                try {
                    Thread.sleep((int)(Math.random() * 100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start(); // 1~1000까지 숫자

        // 버튼을 클릭하면 A~Z 출력

        btn1.addActionListener((e) -> {
            if (state) {
                state = false;
                new Thread(() -> {
                    for (char ch = 'A'; ch <= 'z'; ch++) {
                        text2.setText(ch + "");
                        try {
                            Thread.sleep(100);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    state = true;
                }).start();
            }
        });
    } // 생성자 종료

    public static void main(String[] args) {
        new GUIThreadExam();
    } // main 끝

    /*
     * <InnerClass>
     * 현재 시간을 구해서 JFrame title에 1초마다 시간 갱신하는 스레드
     * */
    class NowTimeThread extends Thread {

        @Override
        public void run() {
            while (true) {
                // 현재 시간 구하기(연, 월, 일, 시, 분, 초)
                Calendar now = Calendar.getInstance();

                int year = now.get(Calendar.YEAR);
                int mon = now.get(Calendar.MONTH) + 1;
                int date = now.get(Calendar.DATE);

                int hour = now.get(Calendar.HOUR);
                int min = now.get(Calendar.MINUTE);
                int sec =  now.get(Calendar.SECOND);

                StringBuilder sb = new StringBuilder();
                sb.append(year).append("년 ");
                sb.append(mon).append("월 ");
                sb.append(date).append("일 ");
                sb.append(hour).append("시 ");
                sb.append(min).append("분 ");
                sb.append(sec).append("초");

                // JFrame의 title에 시계 넣기
                GUIThreadExam.this.setTitle(sb.toString());

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } // while문 끝
        }
    } // innerClass 끝
} // 클래스 끝

