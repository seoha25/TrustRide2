package com.fastcampus.trustRide.dao.admin;

import com.fastcampus.trustRide.dto.CarDto;
import com.fastcampus.trustRide.dto.ImageDto;

public interface CarDao {

    void insetCarInformation(CarDto carDto);

    void insertCarBasicInfo(CarDto carDto);

    void insertCarImage(ImageDto carImageDto);


}
