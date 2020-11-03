package com.cloud.shop.dao;

import com.cloud.shop.entitlse.Specification;
import com.cloud.shop.entitlse.SpecificationOption;
import com.cloud.shop.entitlse.Specifications;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpecificationMapper {

    List<Specification> findSpList();
    Specification findSpById(Long id);
    List<SpecificationOption> findSpOpListBySpId(Long id);
    List<Specification> findSpLikeName(String specName);
    List<Specification> findOptionAll();
    int createSp(Specification specification);
    int createSpOp(SpecificationOption specificationOption);
    int updateSp(Specification specification);
    int updateSpOp(SpecificationOption specificationOption);
    int deleteSp(Long[] ids);
    int deleteSpOp(Long id);
}
