package com.fastcampus.trustRide.dao.admin;

import com.fastcampus.trustRide.dto.CarDto;
import com.fastcampus.trustRide.dto.ImageDto;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao{
    @Autowired
    private SqlSession sqlSession;
    private static final String namespace="carMapper..";


    @Override
    public void insetCarInformation(CarDto carDto) {
        sqlSession.insert(namespace+"insertCarInformation",carDto);
    }

    @Override
    public void insertCarBasicInfo(CarDto carDto) {
        sqlSession.insert(namespace+"insertCarBasicInfo",carDto);

    }

    @Override
    public void insertCarImage(ImageDto carImageDto) {
        sqlSession.insert(namespace+"insertCarImage", carImageDto);

    }
}
