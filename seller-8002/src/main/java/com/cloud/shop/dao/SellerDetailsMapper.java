package com.cloud.shop.dao;

import com.cloud.shop.entitlse.SellerDetails;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerDetailsMapper {

    SellerDetails findSellerDetailsById(String id);

}
