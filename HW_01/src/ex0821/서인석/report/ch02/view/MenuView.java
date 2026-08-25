package ex0821.서인석.report.ch02.view;

import ex0821.서인석.report.ch02.controller.ProfileController;
import ex0821.서인석.report.ch02.dto.ProfileDto;

import java.util.Scanner;

public class MenuView {
    Scanner sc = new Scanner(System.in);
    ProfileController controller = new ProfileController();

    public void printmenu(){
        while (true) {
            System.out.println("-----------------------------------------");
            System.out.println("1. 프로필 저장\t2. 프로필 불러오기\t3. 종료");
            System.out.println("-----------------------------------------");
            System.out.print("메뉴 선택 > ");

            int menu;
            try {
                menu = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요");
                continue;
            }

            switch (menu) {
                case 1:
                    this.saveProfile(); break;
                case 2:
                    this.loadProfile(); break;
                case 3:
                    this.weightUpdate(); break;
                case 4:
                    this.passwordUpdate(); break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("메뉴는 1~3만 입력해주세요.");
            }
        }
    }

    public void saveProfile() {
        ProfileDto profileDto = new ProfileDto();

        //키보드입력 3개 받기
        System.out.print("이름 > ");
        profileDto.setName(sc.nextLine());

        System.out.print("몸무게 > ");
        profileDto.setWeight(Integer.parseInt(sc.nextLine()));

        System.out.print("비밀번호 > ");
        profileDto.setPassword(Integer.parseInt(sc.nextLine()));

        controller.saveProfile(profileDto);
    }

    public void loadProfile() {
        System.out.print("이름 > ");
        String name = sc.nextLine();

        controller.loadProfile(name);
    }

    public void weightUpdate() {

    }

    public void passwordUpdate() {

    }

}
