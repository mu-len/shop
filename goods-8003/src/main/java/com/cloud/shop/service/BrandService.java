package com.cloud.shop.service;

import com.cloud.shop.entitlse.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {

    List<Brand> findPageBrandList(Integer pageNum, Integer pageSize);
    List<Brand> findAllOption();
    Brand findBrandById(Long id);
    boolean findIdByName(String name);
    int updateBrand(Brand brand);
    int createBrand(Brand brand);
    int deleteBrand(Long id);
    int deleteSelection(Long[] ids);
}
