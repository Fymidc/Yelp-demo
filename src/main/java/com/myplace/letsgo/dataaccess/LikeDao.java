package com.myplace.letsgo.dataaccess;

import java.util.Optional;

import com.myplace.letsgo.models.Like;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeDao extends JpaRepository<Like,Long> {

    Optional<Long> findByCustomerId(Optional<Long> customerid);

    Optional<Long> findByRestaurantId(Optional<Long> restaurantid);
    
}
