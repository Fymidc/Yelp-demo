package com.myplace.letsgo.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.myplace.letsgo.dto.LikeCreateRequest;
import com.myplace.letsgo.dto.LikeResponse;
import com.myplace.letsgo.models.Like;


public interface LikeService {

    List<LikeResponse> getAllLikes(Optional<Long> customerid,Optional<Long> restaurantid);

    void deleteOneLike(Long id);

    Like createOneLike(LikeCreateRequest request);
}
