package com.fastcampus.trustRide.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Introspector;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDto {
    // 차량 정보 (car_Info)
    private Integer carInfoId;//차량 정보 아이디
    private String modelName; //모델명
    private String engineCapacity;//배기량
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
    private String vinNumber;//차대번호
    private String offerReportNumber;//제시신고번호
    private String manufactureYear;//연식
    private Integer previousRegistrationFee;//이전등록비
    private Integer maintenanceCost; //관리비용
    private Integer itemPrice;//매물가격
    private Integer extendedWarrantyPrice;//연장보증비
    private String carNum;//차량번호
    private String carLocation;//차량 위치


    //이미지 추후 추가
    private List<ImageDto> images;

    //썸네일
    private String thumbnailUrl;
    private Integer thumbnailImageId;

    //db상관 x
    private Boolean isWished;





     //카테고리 추후 추가
 








}
