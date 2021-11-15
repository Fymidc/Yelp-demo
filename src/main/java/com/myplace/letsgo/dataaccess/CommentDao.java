package com.myplace.letsgo.dataaccess;

import java.util.List;

import com.myplace.letsgo.models.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment,Long>{

    List<Comment> findByCustomerId(Long long1);

    List<Comment> findByRestaurantId(Long long1);

    List<Comment> findByCustomerIdAndRestaurantId(Long long1, Long long2);
    
}
