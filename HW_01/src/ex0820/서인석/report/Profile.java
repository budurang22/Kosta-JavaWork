package ex0820.서인석.report;

import java.io.*;
import java.util.Scanner;

public class Profile {
    Scanner sc = new Scanner(System.in);

    public void printmenu(){
        try {
            while (true) {
                System.out.println("다음 사항에 맞게 입력하여 주십시오.");
                System.out.println("몸무게 입력은 1번");
                System.out.println("몸무게 검색은 2번");
                System.out.println("몸무게 변경은 3번");
                System.out.println("비밀번호 변경은 4번");
                System.out.println("프로그램 종료는 5번");
                System.out.println("을 입력 후 Enter 을 눌러 주세요.");

                System.out.print("메뉴 선택 : ");
                int menu = Integer.parseInt(sc.nextLine());

                switch (menu) {
                    case 1:
                        this.saveProfile();
                        break;
                    case 2:
                        this.loadProfile();
                        break;
                    case 3:
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    default:
                        System.out.println("메뉴는 1~3만 입력해주세요.");
                }//switch문
            }//while문
        } catch (IOException e) {
            System.out.println(e.getMessage() + ".");
        }
    }

    public void saveProfile() throws IOException {
        ProfileDto pro = new ProfileDto();

        //키보드입력 3개 받기
        System.out.print("이름 > ");
        pro.name = sc.nextLine();

        System.out.print("몸무게 > ");
        pro.weight = Integer.parseInt(sc.nextLine());

        System.out.print("비밀번호 > ");
        pro.password = Integer.parseInt(sc.nextLine());

        File file = new File(pro.name + ".txt");

        // 이미 저장된 이름이면 중복 처리
        if (file.exists()) {
            throw new IOException("이미 존재하므로 다시 입력하세요.");
        }
        file.createNewFile();

        // try-with-resources: FileOutputStream이 AutoCloseable을 구현하므로
        // 블록이 끝나면(예외 발생 포함) 자동으로 close() 호출됨
        try (FileOutputStream fos = new FileOutputStream(file)) {
            String data = pro.weight + ":" + pro.password;
            fos.write(data.getBytes());

            System.out.println(pro.name + "의 프로필 저장완료");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadProfile() {
        System.out.print("이름 > ");
        String name = sc.nextLine();

        try (FileInputStream fis = new FileInputStream(name + ".txt")) {
            int len = fis.available();
            byte[] b = new byte[len];
            fis.read(b);

            String str = new String(b);
            String[] arr = str.split(":"); // arr[0] = 몸무게, arr[1] = 비밀번호

            System.out.println(name + "님 몸무게는 " + arr[0] + "kg 이고 비번은 " + arr[1] + " 입니다.");

        } catch (FileNotFoundException e) {
            System.out.println(name + "에 해당하는 정보는 없습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Profile().printmenu();
    }
}
