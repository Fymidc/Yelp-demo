package com.myplace.letsgo.business.abstracts;

import java.util.List;

import com.myplace.letsgo.dto.RestaurantCreateRequest;
import com.myplace.letsgo.dto.RestaurantUpdateRequest;
import com.myplace.letsgo.models.Restaurant;

public interface RestaurantService {
    
    List<Restaurant> getAllRestaurant();
    List<Restaurant> getByRestaurantNameStartsWith(String restaurantName);
    List<Restaurant> getByRestaurantNameContains(String restaurantName);

    Restaurant getOneRestaurantById(Long restaurantid);

    Restaurant createOneRestaurant(RestaurantCreateRequest newRestaurant);

    Restaurant updateOneRestaurant(Long id, RestaurantUpdateRequest request);

    void deleteOneRestaurantById(Long restaurantid);


}
