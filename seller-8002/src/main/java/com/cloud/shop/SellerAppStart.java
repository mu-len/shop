package com.cloud.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SellerAppStart {

    public static void main(String[] args) {
        SpringApplication.run(SellerAppStart.class,args);
    }
}
