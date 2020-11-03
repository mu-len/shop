package com.cloud.shop.service;

import com.cloud.shop.dao.ItemMapper;
import com.cloud.shop.entitlse.Item;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Resource
    private ItemMapper itemMapper;

    @Override
    public List<Item> findAllItem() {
        return itemMapper.findAllItem();
    }

    @Override
    public int createItem(Item item) {
        return itemMapper.createItem(item);
    }

    @Override
    public int deleteItem(Long id) {
        return itemMapper.deleteItem(id);
    }


}
