package com.myplace.letsgo.dto;

import com.myplace.letsgo.models.Like;

import lombok.Data;

@Data
public class LikeResponse {
    private Long id;
    private Long customerId;
    private Long restaurantId;

    public LikeResponse(Like entity) {
        this.id =entity.getId();
        this.customerId = entity.getCustomer().getId();
        this.restaurantId = entity.getRestaurant().getId();
    }

}
