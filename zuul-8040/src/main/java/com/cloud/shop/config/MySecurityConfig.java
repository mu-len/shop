package com.cloud.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/certification/**").permitAll()
                .antMatchers("/zuul/**").permitAll()

                .antMatchers("/query/content/**").hasAnyAuthority("CONTENT")
                .antMatchers("/query/goods/**").hasAnyAuthority("GOODS")
                .antMatchers("/query/sellerSimple/**").hasAnyAuthority("SELLER")
                .antMatchers("/query/sellerDetails/**").hasAnyAuthority("SELLER")
                .antMatchers("/query/specification/**").hasAnyAuthority("SPECIFICATION")

                .antMatchers("/**").fullyAuthenticated()
                .and()
                .csrf().disable()
                .httpBasic();
    }


}
