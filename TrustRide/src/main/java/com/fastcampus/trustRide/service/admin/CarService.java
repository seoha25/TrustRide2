package com.fastcampus.trustRide.service.admin;

import com.fastcampus.trustRide.dto.CarDto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CarService {

    //차량 등록 + 파일 등록
    @Transactional
    void registerCarWithFiles(CarDto carDto, List<MultipartFile> imageFiles, Integer thumbnailIndex);
}
