package com.example.demo.user.repository;

import com.example.demo.user.dao.UserDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    UserDao findByUsername(UserDao userDao);

    void create(UserDao userDao);
}
