package com.myplace.letsgo.dataaccess;

import java.util.List;

import com.myplace.letsgo.models.Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantDao extends JpaRepository<Restaurant,Long>{
    List<Restaurant> getByRestaurantNameContains(String restaurantName);
    List<Restaurant> getByRestaurantNameStartsWith(String restaurantName);
}
