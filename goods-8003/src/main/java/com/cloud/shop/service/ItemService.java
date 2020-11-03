package com.cloud.shop.service;

import com.cloud.shop.entitlse.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    List<Item> findAllItem();
    int createItem(Item item);
    int deleteItem(Long id);

}
