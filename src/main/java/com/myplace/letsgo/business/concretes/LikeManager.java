package com.myplace.letsgo.business.concretes;

import java.util.List;
import java.util.Optional;

import com.myplace.letsgo.business.abstracts.LikeService;
import com.myplace.letsgo.dataaccess.CustomerDao;
import com.myplace.letsgo.dataaccess.LikeDao;
import com.myplace.letsgo.dataaccess.RestaurantDao;
import com.myplace.letsgo.dto.LikeCreateRequest;
import com.myplace.letsgo.models.Customer;
import com.myplace.letsgo.models.Like;
import com.myplace.letsgo.models.Restaurant;

import org.springframework.stereotype.Service;

@Service
public class LikeManager implements LikeService {


    private final LikeDao likedao;
    private final RestaurantDao restaurantDao;
    private final CustomerDao customerDao;
    

    public LikeManager(LikeDao likedao, RestaurantDao restaurantDao, CustomerDao customerDao) {
        this.likedao = likedao;
        this.restaurantDao = restaurantDao;
        this.customerDao = customerDao;
    }

    @Override
    public List<Like> getAllLikes(Optional<Long> customerid, Optional<Long> restaurantid) {
       
        if(customerid.isPresent()){
            likedao.findByCustomerId(customerid).get();
        }else if (restaurantid.isPresent()){
            likedao.findByRestaurantId(restaurantid).get();
        }else{
            likedao.findAll();
        }

        return null;
    }

    @Override
    public void deleteOneLike(Long id) {
        likedao.deleteById(id);
        
    }

    @Override
    public Like createOneLike(LikeCreateRequest request) {
        Restaurant restaurant = restaurantDao.findById(request.getRestaurantid()).get();
        Customer customer = customerDao.findById(request.getCustomerid()).get();


        Like likeToSave = new Like();
         likeToSave.setId(request.getId());
         likeToSave.setCustomer(customer);
         likeToSave.setRestaurant(restaurant);

        return likedao.save(likeToSave);
    }

   
}
