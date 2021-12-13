package com.myplace.letsgo.dataaccess;

import java.util.List;

import com.myplace.letsgo.models.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment,Long>{

    List<Comment> findByCustomerId(Long customerid);

    List<Comment> findByRestaurantId(Long restaurantid);

    List<Comment> findByCustomerIdAndRestaurantId(Long customerid, Long restaurantid);
    
}
