package ex0821.서인석.report.ch02.service;

import ex0821.서인석.report.ch02.dto.ProfileDto;

import java.io.IOException;

public interface ProfileService {
    String buildSaveData(ProfileDto profileDto);
    ProfileDto parseLoadData(String name, String data);
}
