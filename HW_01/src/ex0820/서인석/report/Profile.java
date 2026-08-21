package ex0820.서인석.report;

import java.io.*;
import java.util.Scanner;

public class Report {
    Scanner sc = new Scanner(System.in);

    public void printmenu(){
        while(true){
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("1. 프로필 저장\t2. 프로필 불러오기\t3. 종료");
            System.out.println("----------------------------------------------------------------------------");

            System.out.print("메뉴 선택 > ");
            int menu = Integer.parseInt(sc.nextLine());

            switch(menu){
                case 1 :
                    this.inputInsert(); break;
                case 2 :
                    this.selectAll(); break;
                case 3 :
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("메뉴는 1~3만 입력해주세요.");
            }//switch문

        }//while문
    }

    public void inputInsert() {
        ProfileDto pro = new ProfileDto();

        //키보드입력 3개 받기
        System.out.print("이름 > ");
                pro.name = sc.nextLine();

        System.out.print("몸무게 > ");
        pro.weight = Integer.parseInt(sc.nextLine());

        System.out.print("비밀번호 > ");
        pro.password = Integer.parseInt(sc.nextLine());

        FileOutputStream fos = null;
        try {
            File file = new File(pro.name + ".txt");

            // 이미 저장된 이름이면 중복 처리
            if (file.exists()) {
                System.out.println("이미 존재하므로 다시 입력하세요.");
                return;
            }

            file.createNewFile();

            fos = new FileOutputStream(file);
            String data = pro.weight + ":" + pro.password;
            fos.write(data.getBytes());

            System.out.println("프로필 저장완료");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void selectAll() {
        System.out.print("이름> ");
        String name = sc.nextLine();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(name + ".txt");

            int len = fis.available();
            byte[] b = new byte[len];
            fis.read(b);

            String str = new String(b);
            String[] arr = str.split(":"); // arr[0] = 몸무게, arr[1] = 비밀번호

            System.out.println(name + "님 몸무게는 " + arr[0] + "kg 이고 비번은 " + arr[1] + " 입니다.");

        } catch (FileNotFoundException e) {
            System.out.println(name + "에 해당하는 정보는 없습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Report().printmenu();
    }
}
3