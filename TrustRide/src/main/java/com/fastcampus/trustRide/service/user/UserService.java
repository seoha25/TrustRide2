package com.fastcampus.trustRide.service.user;

import com.fastcampus.trustRide.dto.UserDto;

public interface UserService {

    // 사용자 회원가입 등록
    void registerUser(UserDto user);

    // 사용자 이메일 찾기
    UserDto findUserByEmail(String email);
}
