package com.cloud.shop.service;

import com.cloud.shop.dao.BrandMapper;
import com.cloud.shop.entitlse.Brand;
import com.cloud.shop.utils.HanYu;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    private List<String> list=new ArrayList<>();

    @Override
    public List<Brand> findPageBrandList(Integer pageNum,Integer pageSize) {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findPageBrandList"+pageNum+pageSize;
        Object o = redisTemplate.boundValueOps(key).get();
        if(o==null){
            PageHelper.startPage(pageNum,pageSize);
            List<Brand> brandList = brandMapper.findBrandList();
            PageInfo<Brand> pageInfo=new PageInfo<>(brandList);
            list.add(key);
            redisTemplate.boundValueOps(key).set(pageInfo.getList());
            return pageInfo.getList();
        }
        return (List<Brand>) o;

    }

    @Override
    public List<Brand> findAllOption() {
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        String key="findAllOption";
        Object o = redisTemplate.boundValueOps(key).get();
        if(o==null){
            List<Brand> brandList = brandMapper.findBrandList();
            redisTemplate.boundValueOps(key).set(brandList);
            list.add(key);
            return brandList;
        }
        return (List<Brand>) o;
    }

    @Override
    public Brand findBrandById(Long id) {
        return brandMapper.findBrandById(id);
    }

    @Override
    public boolean findIdByName(String name) {
        return null==brandMapper.findIdByName(name);
    }

    @Override
    public int updateBrand(Brand brand) {
        brand.setFirstChar(HanYu.getShuPing(brand.getName()).substring(0, 1));
        int i = brandMapper.updateBrand(brand);
        if(i>0){
            this.deleteBrandRedis();
        }
        return i;
    }

    @Override
    public int createBrand(Brand brand) {
        if(!this.findIdByName(brand.getName()))return 0;
        brand.setFirstChar(HanYu.getShuPing(brand.getName()).substring(0, 1));
        int i=brandMapper.createBrand(brand);
        if(i>0){
            this.deleteBrandRedis();
        }
        return i;
    }

    @Override
    public int deleteBrand(Long id) {
        int i = brandMapper.deleteBrand(id);
        if(i>0){
            this.deleteBrandRedis();
        }
        return i;
    }

    @Override
    public int deleteSelection(Long[] ids) {
        int i = brandMapper.deleteSelection(ids);
        if(i>0){
            this.deleteBrandRedis();
        }
        return i;
    }

    public void deleteBrandRedis(){
        for (String s : list) {
            redisTemplate.delete(s);
        }
        list.clear();
    }
}
