package com.cloud.shop.dao;

import com.cloud.shop.entitlse.SellerSimple;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SellerSimpleMapper {

    List<SellerSimple> findSeller0SimpleList();
    List<SellerSimple> findSellerSimpleList();
    int stateChange(String sellerId);
    List<SellerSimple> findSS0LikeNANi(@Param("name") String name,@Param("nickName") String nickName);
    List<SellerSimple> findSSLikeNANiByS(@Param("name") String name,@Param("nickName") String nickName,@Param("state")Integer state);


}
