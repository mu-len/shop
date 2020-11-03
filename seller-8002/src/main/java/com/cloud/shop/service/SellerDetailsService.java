package com.cloud.shop.service;

import com.cloud.shop.entitlse.SellerDetails;
import org.springframework.stereotype.Service;

@Service
public interface SellerDetailsService {

    SellerDetails findSellerDetailsById(String id);
}
