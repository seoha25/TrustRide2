package com.fastcampus.trustRide.dao.user;

import com.fastcampus.trustRide.dto.UserDto;

public interface UserDao {

    // 사용자 등록
    void insertUser(UserDto user) ;

    // 사용자 이메일 찾기
    UserDto findUserByEmail(String email);
}
