package com.cloud.shop.service;

import com.cloud.shop.dao.GoodsMapper;
import com.cloud.shop.entitlse.Goods;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService{

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    private List<String> list=new ArrayList<>();

    @Override
    public List findGoodsList(Integer pageNum, Integer pageSize) {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findGoodsList"+pageNum+pageSize;
        Object o = redisTemplate.boundValueOps(key).get();
        if(o==null){
            PageHelper.startPage(pageNum,pageSize);
            PageInfo<Goods> pageInfo=new PageInfo<>(goodsMapper.findGoodsList());
            redisTemplate.boundValueOps(key).set(pageInfo.getList());
            list.add(key);
            return pageInfo.getList();
        }
        return (List<Goods>) o;

    }

    @Override
    public Goods findGoodsById(Long id) {
        return goodsMapper.findGoodsById(id);
    }

    @Override
    public List<Goods> findLikeName(String name) {
        return goodsMapper.findLikeName(name);
    }

    @Override
    public int deleteGoods(Long[] ids) {
        int i = goodsMapper.deleteGoods(ids);
        if(i>0){
            this.deleteGoodsRedis();
        }
        return i;
    }

    public void deleteGoodsRedis(){
        for (String s : list) {
            redisTemplate.delete(s);
        }
        list.clear();
    }
}
