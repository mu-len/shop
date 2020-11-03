package com.cloud.shop.dao;

import com.cloud.shop.entitlse.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandMapper {

    List<Brand> findBrandList();
    Brand findBrandById(Long id);
    Long findIdByName(String name);
    int updateBrand(Brand brand);
    int createBrand(Brand brand);
    int deleteBrand(Long id);
    int deleteSelection(Long[] ids);
}
