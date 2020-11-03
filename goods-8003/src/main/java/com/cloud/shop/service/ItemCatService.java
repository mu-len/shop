package com.cloud.shop.service;

import com.cloud.shop.entitlse.ItemCat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemCatService {

    List<ItemCat> findPICPageList();
    List<ItemCat> findPageAllList(Integer pageNum,Integer pageSize);
    List<ItemCat> findCICPageList(Long parentId);
    List<ItemCat> findICLikeName(String name);
    int createIC(ItemCat itemCat);
    int updateIC(ItemCat itemCat);
    int deleteIC(Long id);
    int deleteICs(Long[] ids);
}
