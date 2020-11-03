package com.cloud.shop.service;

import com.cloud.shop.dao.SellerDetailsMapper;
import com.cloud.shop.entitlse.SellerDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SellerDetailsServiceImpl implements SellerDetailsService{

    @Resource
    private SellerDetailsMapper sellerDetailsMapper;

    @Override
    public SellerDetails findSellerDetailsById(String id) {
        return sellerDetailsMapper.findSellerDetailsById(id);
    }
}
