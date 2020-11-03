package com.cloud.shop.dao;

import com.cloud.shop.entitlse.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {

    List<Goods> findGoodsList();
    Goods findGoodsById(Long id);
    List<Goods> findLikeName(String name);
    int deleteGoods(Long[] ids);
}
