package com.cloud.shop.service;


import com.cloud.shop.entitlse.User;
import org.springframework.stereotype.Service;

@Service
public interface CertificationService {

    User findUserByName(String username);
    User findUserByUAndP(String username, String password);
    User findUserById(Long id);
    int createUser(User user);


}
