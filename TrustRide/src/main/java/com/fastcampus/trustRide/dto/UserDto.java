package com.fastcampus.trustRide.dto;


import lombok.Data;

import java.util.Date;

    @Data
    public class UserDto {
        private Integer userId;              // 유저 아이디
        private String userEmail;            // 유저 이메일
        private String userPassword;         // 유저 비밀번호
        private String userPhoneNumber;      // 유저 전화번호
        private String userName;             // 유저 이름

}
