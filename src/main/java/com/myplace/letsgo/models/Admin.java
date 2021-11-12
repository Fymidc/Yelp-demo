package com.myplace.letsgo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Admin extends User{
    private Long id;
    public Admin(String userName, String password,Long id) {
        super(userName, password);
        this.id=id;
        //TODO Auto-generated constructor stub
    }
    
}
