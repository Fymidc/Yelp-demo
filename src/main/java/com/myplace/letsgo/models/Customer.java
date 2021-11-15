package com.myplace.letsgo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    private String email;
    private String[] favorites;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Comment comment;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
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
