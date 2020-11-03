package com.cloud.shop.dao;

import com.cloud.shop.entitlse.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    List<Item> findAllItem();

    int createItem(Item item);
    int deleteItem(Long id);
}
