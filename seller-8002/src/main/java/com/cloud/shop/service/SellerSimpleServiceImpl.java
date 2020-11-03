package com.cloud.shop.service;

import com.cloud.shop.dao.SellerSimpleMapper;
import com.cloud.shop.entitlse.SellerSimple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SellerSimpleServiceImpl implements SellerSimpleService {

    @Resource
    private SellerSimpleMapper sellerMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    private List<String> list=new ArrayList<>();

    @Override
    public List<SellerSimple> findSeller0SimpleList() {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findSeller0SimpleList";
        Object o = redisTemplate.boundValueOps(key).get();
        if(o==null){
            List<SellerSimple> seller0SimpleList = sellerMapper.findSeller0SimpleList();
            redisTemplate.boundValueOps(key).set(seller0SimpleList);
            list.add(key);
        }
        return (List<SellerSimple>) o;
    }

    @Override
    public List<SellerSimple> findSellerSimpleList() {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findSellerSimpleList";
        Object o = redisTemplate.boundValueOps(key).get();
        if(o==null){
            List<SellerSimple> sellerSimpleList = sellerMapper.findSellerSimpleList();
            redisTemplate.boundValueOps(key).set(sellerSimpleList);
            list.add(key);
        }
        return (List<SellerSimple>) o;
    }

    @Override
    public int stateChange(String sellerId) {
        int i = sellerMapper.stateChange(sellerId);
        if(i>0){this.deleteSellerSimpleRedis();}
        return i;
    }

    @Override
    public List<SellerSimple> findSS0LikeNANi(String name, String nickName) {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findSS0LikeNANi"+name+nickName;
        Object o = redisTemplate.boundValueOps(key).get();
        if(o==null){
            List<SellerSimple> ss0LikeNANi = sellerMapper.findSS0LikeNANi(name, nickName);
            redisTemplate.boundValueOps(key).set(ss0LikeNANi);
            list.add(key);
        }
        return (List<SellerSimple>) o;
    }

    @Override
    public List<SellerSimple> findSSLikeNANiByS(String name, String nickName, Integer state) {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findSSLikeNANiByS"+name+nickName+state;
        Object o = redisTemplate.boundValueOps(key).get();
        if(o==null){
            List<SellerSimple> ssLikeNANiByS = sellerMapper.findSSLikeNANiByS(name, nickName, state);
            redisTemplate.boundValueOps(key).set(ssLikeNANiByS);
            list.add(key);
        }
        return (List<SellerSimple>) o;
    }

    public void deleteSellerSimpleRedis(){
        for (String s : list) {
            redisTemplate.delete(s);
        }
        list.clear();
    }
}
