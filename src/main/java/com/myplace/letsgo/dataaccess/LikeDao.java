package com.myplace.letsgo.dataaccess;

import java.util.List;
import java.util.Optional;

import com.myplace.letsgo.models.Like;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeDao extends JpaRepository<Like,Long> {

    List<Like> findByCustomerId(Long long1);

    List<Like> findByCustomerIdAndRestaurantId(Long long1, Long long2);

    List<Like> findByRestaurantId(Long long1);
    
}
