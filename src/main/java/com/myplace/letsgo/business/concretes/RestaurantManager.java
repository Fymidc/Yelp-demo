package com.myplace.letsgo.business.concretes;

import java.util.List;
import java.util.Optional;

import com.myplace.letsgo.business.abstracts.RestaurantService;
import com.myplace.letsgo.dataaccess.RestaurantDao;
import com.myplace.letsgo.dto.RestaurantCreateRequest;
import com.myplace.letsgo.dto.RestaurantUpdateRequest;
import com.myplace.letsgo.models.Restaurant;

import org.springframework.stereotype.Service;

@Service
public class RestaurantManager implements RestaurantService{

    private final RestaurantDao restaurantdao;

    public RestaurantManager(RestaurantDao restaurantdao) {
        this.restaurantdao = restaurantdao;
    }


    
    @Override
    public List<Restaurant> getAllRestaurant() {
        
        return restaurantdao.findAll();
    }

    public List<Restaurant> getByRestaurantNameContains(String restaurantName) {
        
        return restaurantdao.getByRestaurantNameContains(restaurantName);
    }

    @Override
    public Restaurant getOneRestaurantById(Long restaurantid) {
        
        return restaurantdao.findById(restaurantid).get();
    }

    @Override
    public Restaurant createOneRestaurant(RestaurantCreateRequest newRestaurant) {
    
        Restaurant restaurantToSave = new Restaurant();
        restaurantToSave.setId(newRestaurant.getId());
        restaurantToSave.setRestaurantName(newRestaurant.getRestaurantName());
        restaurantToSave.setInfo(newRestaurant.getInfo());
        restaurantToSave.setAdress(newRestaurant.getAdress());
        restaurantToSave.setTelno(newRestaurant.getTelno());
        restaurantToSave.setWebsite(newRestaurant.getWebsite());
        restaurantToSave.setImages(newRestaurant.getImages());
        restaurantToSave.setMenu(newRestaurant.getMenu());
        restaurantToSave.setAmenities(newRestaurant.getAmenities());
        restaurantToSave.setOpen(newRestaurant.isOpen());

        return restaurantdao.save(restaurantToSave);
    }

    @Override
    public Restaurant updateOneRestaurant(Long id, RestaurantUpdateRequest request) {
        
        Optional<Restaurant> restaurant =restaurantdao.findById(id);

        if(restaurant.isPresent()){
            Restaurant toSave = restaurant.get();

            toSave.setRestaurantName(request.getRestaurantName());
            toSave.setInfo(request.getInfo());
            toSave.setAdress(request.getAdress());
            toSave.setTelno(request.getTelno());
            toSave.setWebsite(request.getWebsite());
            toSave.setImages(request.getImages());
            toSave.setMenu(request.getMenu());
            toSave.setAmenities(request.getAmenities());
            toSave.setOpen(request.isOpen());
            
            return restaurantdao.save(toSave);
        }

        return null;
    }

    @Override
    public void deleteOneRestaurantById(Long restaurantid) {
        restaurantdao.deleteById(restaurantid);
        
    }



    @Override
    public List<Restaurant> getByRestaurantNameStartsWith(String restaurantName) {
       
        return restaurantdao.getByRestaurantNameStartsWith(restaurantName);
    }
    
}
