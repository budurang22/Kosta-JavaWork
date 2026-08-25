package ex0821.서인석.report.ch02.controller;

import ex0821.서인석.report.ch02.dto.ProfileDto;
import ex0821.서인석.report.ch02.service.ProfileService;
import ex0821.서인석.report.ch02.service.ProfileServiceImpl;
import ex0821.서인석.report.ch02.view.FailView;
import ex0821.서인석.report.ch02.view.SuccessView;

import java.io.*;
import java.util.List;

public class ProfileController {

    private ProfileService service = ProfileServiceImpl.getInstance();

    public void saveProfile(ProfileDto profileDto) {
        File file = new File(profileDto.getName() + ".txt");

        if (file.exists()) {
            FailView.errorMessage("이미 존재하므로 다시 입력하세요.");
            return;
        }

        try (FileOutputStream fos = new FileOutputStream(file)) {
            String data = service.buildSaveData(profileDto);
            fos.write(data.getBytes());
            SuccessView.printMessage(profileDto.getName() + "의 프로필 저장완료");
        } catch (IOException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

   public void loadProfile(String name) {
        try (FileInputStream fis = new FileInputStream(name + ".txt")) {
            int len = fis.available();
            byte[] b = new byte[len];
            fis.read(b);

            ProfileDto profileDto = service.parseLoadData(name, new String(b));
            SuccessView.printProfile(profileDto);
        } catch (FileNotFoundException e) {
            FailView.errorMessage(name + "에 해당하는 정보는 없습니다.");
        } catch (IOException e) {
            FailView.errorMessage(e.getMessage());
        }
   }
}
