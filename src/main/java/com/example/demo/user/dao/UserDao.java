package com.example.demo.user.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDao {
    private Long id;
    private String password;
    private String username;
    public UserDao(String  username){
        this.username = username;
    }
}
