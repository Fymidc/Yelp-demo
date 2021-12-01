package com.myplace.letsgo.controller;

import java.util.List;

import com.myplace.letsgo.business.abstracts.RestaurantService;
import com.myplace.letsgo.dto.RestaurantCreateRequest;
import com.myplace.letsgo.dto.RestaurantUpdateRequest;
import com.myplace.letsgo.exception.RestaurantNotFoundException;
import com.myplace.letsgo.models.Restaurant;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {
    
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurant(){
       return restaurantService.getAllRestaurant();
    }

    @GetMapping("/{restaurantid}")
    public Restaurant getOneRestaurantById(@PathVariable Long restaurantid )throws Exception{


    try {
        return restaurantService.getOneRestaurantById(restaurantid);
    } catch (RestaurantNotFoundException e) {
      throw new RestaurantNotFoundException("restaurant not found"+restaurantid);
    }
        

    }

    @PostMapping
    public Restaurant createOneRestaurant(@RequestBody RestaurantCreateRequest newRestaurant)throws Exception{

        try {
           return restaurantService.createOneRestaurant(newRestaurant);    
        } catch (Exception e) {
            throw new Exception("cannot create restaurant"); 
        }
        
        
    }

    @PutMapping("/{id}")
    public Restaurant updateRestaurant(@PathVariable Long id,@RequestBody RestaurantUpdateRequest request){
        return restaurantService.updateOneRestaurant(id, request);

    }

    @DeleteMapping("/{restaurantid}")
    public void deleteOneRestaurantById(@PathVariable Long restaurantid){
        restaurantService.deleteOneRestaurantById(restaurantid);
    }

    @GetMapping("/sw/{restaurantName}")
    public List <Restaurant> getByRestaurantNameStartsWith(@PathVariable String restaurantName){
            return restaurantService.getByRestaurantNameStartsWith(restaurantName);
    }

    @GetMapping("/cn/{restaurantName}")
    public List <Restaurant> getByRestaurantNameContains(@PathVariable String restaurantName){
            return restaurantService.getByRestaurantNameContains(restaurantName);
    }

}

//restaurant oluşturuldu id-2 (id 3-4) düzenle