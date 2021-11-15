package com.myplace.letsgo.dto;

import com.myplace.letsgo.models.Comment;

import lombok.Data;

@Data
public class CommentResponse {
    private Long id;
    private String text;
    private Long customerId;
    private String customerName;
    private Long restaurantId;

    public CommentResponse(Comment entity) {
        this.id =entity.getId();
        this.text = entity.getText();
        this.customerId = entity.getCustomer().getId();
        this.customerName = entity.getCustomer().getUserName();
        this.restaurantId = entity.getRestaurant().getId();
    }

    
}
