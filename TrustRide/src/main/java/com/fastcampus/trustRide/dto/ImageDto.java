package com.fastcampus.trustRide.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {
    private Integer imageId;
    private String  imageUrl;
    private String imageType;
    private String imageContent;
    private Integer carInfoId;
    private Integer reviewId;
    private  Integer inquiryId;

    private Boolean isThumbnail;

}
