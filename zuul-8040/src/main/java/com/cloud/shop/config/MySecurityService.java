package com.cloud.shop.config;

import com.cloud.shop.dao.UserMapper;
import com.cloud.shop.entitlse.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class MySecurityService implements UserDetailsService {

    @Resource
    private MyPassword myPassword;

    @Resource
    private UserMapper certificationService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User userByName = certificationService.findUserByName(s);
        String encode = myPassword.getPasswordEncoder().encode(userByName.getPassword());
        return new org.springframework.security.core.userdetails.User(s,encode,authorities(userByName.getAuthority()));
    }

    public Collection<GrantedAuthority> authorities(String authorities){

        String[] split = authorities.split(",");
        List<GrantedAuthority> list=new ArrayList<>();
        for (String s : split) {
            list.add(new SimpleGrantedAuthority(s));
        }
        return list;
    }
}
