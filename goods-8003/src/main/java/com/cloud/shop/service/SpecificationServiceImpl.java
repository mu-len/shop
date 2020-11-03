package com.cloud.shop.service;

import com.cloud.shop.dao.SpecificationMapper;
import com.cloud.shop.entitlse.Specification;
import com.cloud.shop.entitlse.SpecificationOption;
import com.cloud.shop.entitlse.Specifications;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpecificationServiceImpl implements SpecificationService{

    @Resource
    private SpecificationMapper specificationMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    private List<String> list=new ArrayList<>();

    @Override
    public List findSpList(Integer pageNum, Integer pageSize) {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findSpList"+pageNum+pageSize;
        Object o = redisTemplate.boundValueOps(key).get();
        if(o==null){
            PageHelper.startPage(pageNum,pageSize);
            List<Specification> spList = specificationMapper.findSpList();
            PageInfo pageInfo=new PageInfo(spList);
            redisTemplate.boundValueOps(key).set(spList);
            list.add(key);
            return pageInfo.getList();
        }
        return (List) o;
    }

    @Override
    public Specifications findSpOpListBySpId(Long id) {
        Specifications specifications = new Specifications();
        specifications.setSpecification(specificationMapper.findSpById(id));
        specifications.setSpecificationOptions(specificationMapper.findSpOpListBySpId(id));
        return specifications;
    }

    @Override
    public List<Specification> findSpLikeName(String specName) {
        return specificationMapper.findSpLikeName(specName);
    }

    @Override
    public List<Specification> findOptionAll() {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findOptionAll";
        Object o = redisTemplate.boundValueOps(key).get();
        if(o==null){
            List<Specification> optionAll = specificationMapper.findOptionAll();
            redisTemplate.boundValueOps(key).set(optionAll);
            list.add(key);
            return optionAll;
        }
        return (List<Specification>) o;
    }

    @Override
    public int createSp(Specification specification) {
        int i = specificationMapper.createSp(specification);
        if(i>0){this.deleteSpRedis();}
        return i;
    }

    @Override
    public int createSpOp(SpecificationOption specificationOption) {
        int i = specificationMapper.createSpOp(specificationOption);
        if(i>0){this.deleteSpRedis();}
        return i;
    }

    @Override
    public int create(Specifications specifications) {
        Specification specification = specifications.getSpecification();
        int i = specificationMapper.createSp(specification);
        if(i>0){this.deleteSpRedis();}
        if(i>0){
            Long id=specification.getId();
            for(SpecificationOption specificationOption:specifications.getSpecificationOptions()){
                specificationOption.setSpecId(id);
                specificationMapper.createSpOp(specificationOption);
            }
        }
        return i;
    }

    @Override
    public int updateSp(Specification specification) {
        int i = specificationMapper.updateSp(specification);
        if(i>0){this.deleteSpRedis();}
        return i;
    }

    @Override
    public int updateSpOp(SpecificationOption specificationOption) {
        int i = specificationMapper.updateSpOp(specificationOption);
        if(i>0){this.deleteSpRedis();}
        return i;
    }

    @Override
    public int deleteSp(Long[] ids) {
        int i = specificationMapper.deleteSp(ids);
        if(i>0){this.deleteSpRedis();}
        return i;
    }

    @Override
    public int deleteSpOp(Long id) {
        int i = specificationMapper.deleteSpOp(id);
        if(i>0){this.deleteSpRedis();}
        return i;
    }

    public void deleteSpRedis(){
        for (String s : list) {
            redisTemplate.delete(s);
        }
        list.clear();
    }
}
