package com.myplace.letsgo.dto;

import lombok.Data;

@Data
public class UserRequest {
   private String userName;
   private String password;
   private String email;
}
