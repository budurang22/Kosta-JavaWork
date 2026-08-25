package ex0821.서인석.report.ch02.view;

import ex0821.서인석.report.ch02.dto.ProfileDto;

public class SuccessView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printProfile(ProfileDto profileDto) {
        System.out.println(profileDto.getName() + "님 몸무게는 " + profileDto.getWeight() +
                "kg 이고 비번은 " + profileDto.getPassword() + " 입니다.");
    }
}
