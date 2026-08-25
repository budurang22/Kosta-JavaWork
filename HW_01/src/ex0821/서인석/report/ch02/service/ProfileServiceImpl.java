package ex0821.서인석.report.ch02.service;

import ex0821.서인석.report.ch02.dto.ProfileDto;


public class ProfileServiceImpl implements ProfileService {
    private static final ProfileService instance = new ProfileServiceImpl();

    public ProfileServiceImpl() {
    }

    public static ProfileService getInstance() {
        return instance;
    }

    @Override
    public String buildSaveData(ProfileDto profileDto) {
        return profileDto.getWeight() + ":" + profileDto.getPassword();
    }

    @Override
    public ProfileDto parseLoadData(String name, String data) {
        String[] arr = data.split(":"); // arr[0] = 몸무게, arr[1] = 비밀번호

        ProfileDto profileDto = new ProfileDto();
        profileDto.setName(name);
        profileDto.setWeight(Integer.parseInt(arr[0]));
        profileDto.setPassword(Integer.parseInt(arr[1]));
        return profileDto;
    }
}
