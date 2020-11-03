package com.cloud.shop.dao;

import com.cloud.shop.entitlse.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    User findUserByName(String username);
    User findUserByUAndP(@Param("username") String username,@Param("password") String password);
    User findUserById(Long id);
    int createUser(User user);
}
