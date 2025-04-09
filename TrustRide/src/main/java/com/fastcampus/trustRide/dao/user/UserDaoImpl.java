package com.fastcampus.trustRide.dao.user;

import com.fastcampus.trustRide.dto.UserDto;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSessionTemplate sqlSession;

    private static final String namespace = "com.fastcampus.trustride.dao.userMapper.";

    // 사용자 등록
    @Override
    public void insertUser(UserDto user) {
        sqlSession.insert(namespace + "insertUser", user);
    }
    // 사용자 이메일 찾기
    @Override
    public UserDto findUserByEmail(String email){
        return sqlSession.selectOne(namespace + "findByEmail", email);
    }
}
