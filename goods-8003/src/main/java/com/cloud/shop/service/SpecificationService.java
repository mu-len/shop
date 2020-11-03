package com.cloud.shop.service;

import com.cloud.shop.entitlse.Specification;
import com.cloud.shop.entitlse.SpecificationOption;
import com.cloud.shop.entitlse.Specifications;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SpecificationService {

    List<Specification> findSpList(Integer pageNum,Integer pageSize);
    Specifications findSpOpListBySpId(Long id);
    List<Specification> findSpLikeName(String specName);
    List<Specification> findOptionAll();
    int createSp(Specification specification);
    int createSpOp(SpecificationOption specificationOption);
    int create(Specifications specifications);
    int updateSp(Specification specification);
    int updateSpOp(SpecificationOption specificationOption);
    int deleteSp(Long[] ids);
    int deleteSpOp(Long id);
}
