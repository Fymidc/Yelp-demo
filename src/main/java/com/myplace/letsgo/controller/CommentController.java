package com.myplace.letsgo.controller;

import java.util.List;
import java.util.Optional;

import com.myplace.letsgo.business.abstracts.CommentService;
import com.myplace.letsgo.dto.CommentCreateRequest;
import com.myplace.letsgo.dto.CommentResponse;
import com.myplace.letsgo.dto.CommentUpdateRequest;
import com.myplace.letsgo.models.Comment;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    private final CommentService commentService;

    
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<CommentResponse> getAllComments (@RequestParam Optional<Long> customerid, @RequestParam Optional<Long> restaurantid){
      return commentService.getAllComments(customerid, restaurantid);
    }

    @DeleteMapping("{commentid}")
    public void deleteOneComment(@PathVariable Long commentid){
        commentService.deleteOneComment(commentid);
    }

    @PostMapping
    public Comment creatComment(@RequestBody CommentCreateRequest request){
        return commentService.createOneComment(request);
    }

    @PutMapping("{commentid}")
    public Comment updateoneComment(@PathVariable Long commentid ,@RequestBody CommentUpdateRequest request){
        return commentService.updateOneComment(commentid, request);
    }

}
