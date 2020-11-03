package com.cloud.shop.service;

import com.cloud.shop.entitlse.SellerSimple;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SellerSimpleService {

    List<SellerSimple> findSeller0SimpleList();

    List<SellerSimple> findSellerSimpleList();

    int stateChange(String sellerId);

    List<SellerSimple> findSS0LikeNANi(String name, String nickName);

    List<SellerSimple> findSSLikeNANiByS(String name, String nickName, Integer state);

}
