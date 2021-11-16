package com.myplace.letsgo.controller;

import java.util.List;
import java.util.Optional;

import com.myplace.letsgo.business.abstracts.LikeService;
import com.myplace.letsgo.dto.LikeCreateRequest;
import com.myplace.letsgo.models.Like;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
public class LikeController {
    
    private LikeService likeService;

    @GetMapping
    public List<Like> getAllLikes (@RequestParam Optional<Long> customerid,@RequestParam Optional<Long> restaurantid ){
        return likeService.getAllLikes(customerid, restaurantid);
    }

    @DeleteMapping("/{id}")
    public void deleteOneLike(@PathVariable Long id){
        likeService.deleteOneLike(id);
    }

    @PostMapping
    public Like createOnelLike(LikeCreateRequest request){
        return likeService.createOneLike(request);
    }



}
