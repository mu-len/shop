package com.cloud.shop.service;

import com.cloud.shop.dao.ItemCatMapper;
import com.cloud.shop.entitlse.ItemCat;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService{

    @Resource
    private ItemCatMapper itemCatMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    private List<String> list=new ArrayList<>();

    @Override
    public List<ItemCat> findPICPageList() {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findPICPageList";
        Object o = redisTemplate.boundValueOps(key).get();
        if(o==null){
            List<ItemCat> picPageList = itemCatMapper.findPICPageList();
            redisTemplate.boundValueOps(key).set(picPageList);
            list.add(key);
            return picPageList;
        }
        return (List<ItemCat>) o;
    }

    @Override
    public List findPageAllList(Integer pageNum, Integer pageSize) {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findPageAllList"+pageNum+pageSize;
        Object o = redisTemplate.boundValueOps(key).get();
        if(o==null){
            PageHelper.startPage(pageNum,pageSize);
            PageInfo<ItemCat> pageInfo=new PageInfo<>(itemCatMapper.findPageAllList());
            redisTemplate.boundValueOps(key).set(pageInfo.getList());
            list.add(key);
            return pageInfo.getList();
        }
        return (List<ItemCat>) o;
    }

    @Override
    public List<ItemCat> findCICPageList(Long parentId) {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findCICPageList";
        Object o = redisTemplate.boundValueOps(key).get();
        if(o==null){
            List<ItemCat> cicPageList = itemCatMapper.findCICPageList(parentId);
            redisTemplate.boundValueOps(key).set(cicPageList);
            list.add(key);
        }
        return (List<ItemCat>) o;
    }

    @Override
    public List<ItemCat> findICLikeName(String name) {
        return itemCatMapper.findICLikeName(name);
    }

    @Override
    public int createIC(ItemCat itemCat) {
        int i = itemCatMapper.createIC(itemCat);
        if(i>0){ this.deleteItemCatRedis(); }
        return i;
    }

    @Override
    public int updateIC(ItemCat itemCat) {
        int i = itemCatMapper.updateIC(itemCat);
        if(i>0){ this.deleteItemCatRedis(); }
        return i;
    }

    @Override
    public int deleteIC(Long id) {
        int i = itemCatMapper.deleteIC(id);
        if (i>0){ this.deleteItemCatRedis(); }
        return i;
    }

    @Override
    public int deleteICs(Long[] ids) {
        int i = itemCatMapper.deleteICs(ids);
        if (i>0){ this.deleteItemCatRedis(); }
        return i;
    }

    public void deleteItemCatRedis(){
        for (String s : list) {
            redisTemplate.delete(s);
        }
        list.clear();
    }
}
