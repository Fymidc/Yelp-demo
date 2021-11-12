package com.myplace.letsgo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
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
    private Comment comment;
    private Like like;
    
}
