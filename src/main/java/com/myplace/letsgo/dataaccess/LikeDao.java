package com.myplace.letsgo.dataaccess;

import com.myplace.letsgo.models.Like;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeDao extends JpaRepository<Like,Long> {
    
}
