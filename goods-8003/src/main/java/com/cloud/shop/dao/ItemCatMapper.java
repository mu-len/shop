package com.cloud.shop.dao;

import com.cloud.shop.entitlse.ItemCat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemCatMapper {

    List<ItemCat> findPICPageList();
    List<ItemCat> findPageAllList();
    List<ItemCat> findCICPageList(Long parentId);
    List<ItemCat> findICLikeName(String name);
    int createIC(ItemCat itemCat);
    int updateIC(ItemCat itemCat);
    int deleteIC(Long id);
    int deleteICs(Long[] ids);
}
