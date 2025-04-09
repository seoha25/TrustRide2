package com.fastcampus.trustRide.service.user;

import com.fastcampus.trustRide.dao.user.UserDao;
import com.fastcampus.trustRide.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 사용자 회원가입 등록
    @Override
    public void registerUser(UserDto user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        userDao.insertUser(user);
    }

    // 사용자 이메일 찾기
    @Override
    public UserDto findUserByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
