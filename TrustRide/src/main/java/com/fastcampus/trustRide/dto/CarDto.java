package com.fastcampus.trustRide.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDto {
    // 차량 정보 (car_Info)
    private Integer carInfoId;//차량 정보 아이디
    private String modelName; //모델명
    private String engine_capacity;//배기량
    private String fuelType;//변속기
    private String Color;//색상
    private Integer carPrice; //가격
    private Date createAt;//등록일
    private Date updateAt;//수정일
    private Date deleteAt;//삭제일

    //중고 매물 (used_item)
    private Integer usedItemId;//중고 매물 아이디
    private String title; //제목
    private String description;//상세 설명
    private String mileage; // 주행거리
 





}
