package com.myplace.letsgo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String restaurantName;
    private String[] info;
    private String adress;
    private String telno;
    private String website;
    private String[] images;
    private String menu;
    private String[] amenities;
    private boolean isOpen;

    

    // @JsonIgnore
    // @OneToMany(mappedBy = "restaurant") 
    //private Comment comment; //onetomany için liste döndürmeli,

    //private Like like;
    
}
