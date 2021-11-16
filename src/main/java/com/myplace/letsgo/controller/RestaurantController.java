package com.myplace.letsgo.controller;

import java.util.List;

import com.myplace.letsgo.business.abstracts.RestaurantService;
import com.myplace.letsgo.dto.RestaurantCreateRequest;
import com.myplace.letsgo.dto.RestaurantUpdateRequest;
import com.myplace.letsgo.exception.RestaurantNotFoundException;
import com.myplace.letsgo.models.Restaurant;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAllRestaurant(){
       return restaurantService.getAllRestaurant();
    }

    @GetMapping("/{restaurantid}")
    public Restaurant getOneRestaurantById(@PathVariable Long restaurantid ){

    try {
        return restaurantService.getOneRestaurantById(restaurantid);
    } catch (RestaurantNotFoundException e) {
      throw new RestaurantNotFoundException("restaurant not found"+restaurantid);
    }
        

    }

    @PostMapping
    public Restaurant createOneRestaurant(RestaurantCreateRequest newRestaurant){
        return restaurantService.createOneRestaurant(newRestaurant);
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id,RestaurantUpdateRequest request){
        return restaurantService.updateOneRestaurant(id, request);
    }

    @DeleteMapping("/{restaurantid}")
    public void deleteOneRestaurantById(@PathVariable Long restaurantid){
        restaurantService.deleteOneRestaurantById(restaurantid);
    }

}
