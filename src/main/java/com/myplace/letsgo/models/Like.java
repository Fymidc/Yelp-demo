package com.myplace.letsgo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    private Long id;
    private Restaurant restaurant;
    private Customer customer; 

}
