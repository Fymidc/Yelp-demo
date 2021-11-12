package com.myplace.letsgo.dto;

import lombok.Data;

@Data
public class LikeCreateRequest {
    private Long id;
    private Long customerid;
    private Long restaurantid;
}
