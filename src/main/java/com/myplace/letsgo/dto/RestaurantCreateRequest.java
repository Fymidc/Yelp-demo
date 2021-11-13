package com.myplace.letsgo.dto;

import lombok.Data;

@Data
public class RestaurantCreateRequest {
    private Long id;
    private String restaurantName;
    private String[] info;
    private String adress;
    private String telno;
    private String website;
    private String[] images;
    private String menu;
    private String[] amenities;
    private boolean isOpen;
}
