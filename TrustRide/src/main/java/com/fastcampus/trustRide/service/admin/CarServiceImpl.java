package com.fastcampus.trustRide.service.admin;


import com.fastcampus.trustRide.dao.admin.CarDao;
import com.fastcampus.trustRide.dto.CarDto;
import com.fastcampus.trustRide.dto.ImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
 CarDao carDao;



    @Override
    @Transactional
    public void registerCarWithFiles(CarDto carDto, List<MultipartFile> imageFiles, Integer thumbnailIndex) {
        //차량 정보 등록
        carDao.insertCarBasicInfo(carDto);
        carDao.insetCarInformation(carDto);

        // 2) 이미지 처리
        if (imageFiles != null && !imageFiles.isEmpty()) {
            for (int i = 0; i < imageFiles.size(); i++) {
                MultipartFile file = imageFiles.get(i);
                if (!file.isEmpty()) {
                    try {
                        String originalName = file.getOriginalFilename();
                        if (originalName == null) continue;

                        String uuid = UUID.randomUUID().toString();
                        String savedName = uuid + "_" + originalName;

                        // 저장 경로
                        File dest = new File("C:/upload/" + savedName);
                        file.transferTo(dest);

                        // DTO 생성
                        ImageDto imageDto = new ImageDto();
                        imageDto.setCarInfoId(carDto.getCarInfoId());

                        imageDto.setImageUrl("/uploads/" + savedName);
                        imageDto.setImageType(file.getContentType());
                        imageDto.setIsThumbnail(i == thumbnailIndex); // 썸네일 지정

                        carDao.insertCarImage(imageDto); // DB 저장
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        }





    }

