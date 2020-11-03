package com.cloud.shop.service;

import com.cloud.shop.entitlse.Goods;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsService {

    List<Goods> findGoodsList(Integer pageNum,Integer pageSize);
    Goods findGoodsById(Long id);
    List<Goods> findLikeName(String name);
    int deleteGoods(Long[] ids);
}
