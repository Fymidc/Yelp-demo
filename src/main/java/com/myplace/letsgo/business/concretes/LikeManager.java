package com.myplace.letsgo.business.concretes;

import java.util.List;
import java.util.Optional;

import com.myplace.letsgo.business.abstracts.LikeService;
import com.myplace.letsgo.dataaccess.LikeDao;
import com.myplace.letsgo.dto.LikeCreateRequest;
import com.myplace.letsgo.models.Like;

public class LikeManager implements LikeService {


    private LikeDao likedao;

    @Override
    public List<Like> getAllLikes(Optional<Long> customerid, Optional<Long> restaurantid) {
        //restaurant servici oluştuktan sonra yapılacak
        return null;
    }

    @Override
    public void deleteOneLike(Long id) {
        likedao.deleteById(id);
        
    }

    @Override
    public Like createOneLike(LikeCreateRequest request) {
        //restaurant servici oluştuktan sonra yapılacak
        return null;
    }
    
}
