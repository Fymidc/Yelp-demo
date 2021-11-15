package com.myplace.letsgo.business.abstracts;

import java.util.List;
import java.util.Optional;

import com.myplace.letsgo.dto.CommentCreateRequest;
import com.myplace.letsgo.dto.CommentResponse;
import com.myplace.letsgo.dto.CommentUpdateRequest;
import com.myplace.letsgo.models.Comment;

public interface CommentService {
    
    List<CommentResponse> getAllComments(Optional<Long> customerid,Optional<Long> restaurantid);

    void deleteOneComment(Long commentid);

    Comment createOneComment(CommentCreateRequest request);

    Comment updateOneComment(Long commentid, CommentUpdateRequest request);
}
