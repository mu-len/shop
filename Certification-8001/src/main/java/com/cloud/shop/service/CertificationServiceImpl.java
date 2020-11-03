package com.cloud.shop.service;

import com.cloud.shop.dao.UserMapper;
import com.cloud.shop.entitlse.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CertificationServiceImpl implements CertificationService{

    @Resource
    private UserMapper userMapper;

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    @Override
    public User findUserByUAndP(String username, String password) {
         return userMapper.findUserByUAndP(username,password);
    }

    @Override
    public User findUserById(Long id) {
        return userMapper.findUserById(id);
    }

    @Override
    public int createUser(User user) {
        return userMapper.createUser(user);
    }
}
