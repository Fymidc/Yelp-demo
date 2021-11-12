package com.myplace.letsgo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Customer extends User{
    private Long id;
    private String email;
    private String[] favorites;
    private Comment comment;
    private Like like;

    public Customer(String userName,String password, Long id, String[] favorites,
     Comment comment, Like like,String email) {
       super(userName,password);
        this.id = id;
        this.favorites = favorites;
        this.comment = comment;
        this.like = like;
        this.email=email;
    }



}
