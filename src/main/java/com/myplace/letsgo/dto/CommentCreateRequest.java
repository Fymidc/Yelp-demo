package com.myplace.letsgo.dto;

import lombok.Data;

@Data
public class CommentCreateRequest {
    private Long id;
    private String text;
    private Long restaurantid;
    private Long customerid;
}
