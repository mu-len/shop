package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.Specification;
import com.cloud.shop.entitlse.SpecificationOption;
import com.cloud.shop.entitlse.Specifications;
import com.cloud.shop.service.SpecificationServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SpecificationController {

    @Resource
    private SpecificationServiceImpl specificationService;

    @GetMapping(value = "/specification/findSpList")
    public CommonResult<List<Specification>> findSpList(Integer pageNum,Integer pageSize) {
        List<Specification> spList = specificationService.findSpList(pageNum,pageSize);
        if(spList!=null){
            return new CommonResult<>(200,"查询成功",spList);
        }
        return new CommonResult<>(444,"查询findSpList失败",null);
    }

    @GetMapping(value = "/specification/findSpOpListBySpId")
    public CommonResult<Specifications> findSpOpListBySpId(Long id){
        Specifications spOpListBySpId = specificationService.findSpOpListBySpId(id);
        if(spOpListBySpId!=null){
            return new CommonResult<>(200,"查询成功",spOpListBySpId);
        }
        return new CommonResult<>(444,"查询失败，查询specification id："+id,null);
    }

    @GetMapping(value = "/specification/findSpLikeName")
    public CommonResult<List<Specification>> findSpLikeName(String specName){
        List<Specification> spLikeName = specificationService.findSpLikeName(specName);
        if(spLikeName!=null){
            return new CommonResult<>(200,"查询成功",spLikeName);
        }
        return new CommonResult<>(444,"查询失败,查询条件："+ specName,null);
    }

    @PostMapping(value = "/specification/createSp")
    public CommonResult<Integer> createSp(@RequestBody Specification specification){
        int sp = specificationService.createSp(specification);
        if(sp>0){
            return new CommonResult<>(200,"添加Specification数据成功",sp);
        }
        return new CommonResult<>(406,"添加Specification数据失败,数据："+specification,sp);
    }

    @PostMapping(value = "/specification/createSpOp")
    public CommonResult<Integer> createSpOp(@RequestBody SpecificationOption specificationOption){
        int spOp = specificationService.createSpOp(specificationOption);
        if(spOp>0){
            return new CommonResult<>(200,"添加SpecificationOption数据成功",spOp);
        }
        return new CommonResult<>(406,"添加SpecificationOption数据失败,数据："+specificationOption,spOp);
    }

    @PostMapping(value = "/specification/updateSp")
    public CommonResult<Integer> updateSp(@RequestBody Specification specification){
        int i = specificationService.updateSp(specification);
        if(i>0){
            return new CommonResult<>(200,"修改Specification数据成功",i);
        }
        return new CommonResult<>(406,"修改Specification数据失败,数据："+specification,i);
    }

    @PostMapping(value = "/specification/updateSpOp")
    public CommonResult<Integer> updateSpOp(@RequestBody SpecificationOption specificationOption){
        int i = specificationService.updateSpOp(specificationOption);
        if(i>0){
            return new CommonResult<>(200,"修改SpecificationOption数据成功",i);
        }
        return new CommonResult<>(406,"修改SpecificationOption数据失败,数据："+specificationOption,i);
    }

    @GetMapping(value = "/specification/deleteSp")
    public CommonResult<Integer> deleteSp(Long[] ids){
        int i = specificationService.deleteSp(ids);
        if(i>0){
            return new CommonResult<>(200,"删除Specification数据成功",i);
        }
        return new CommonResult<>(406,"删除Specification数据失败,id："+ids,i);
    }

    @GetMapping(value = "/specification/deleteSpOp")
    public CommonResult<Integer> deleteSpOp(Long id){
        int i = specificationService.deleteSpOp(id);
        if(i>0){
            return new CommonResult<>(200,"删除SpecificationOption数据成功",i);
        }
        return new CommonResult<>(406,"删除SpecificationOption数据失败,id："+id,i);
    }

    @PostMapping(value = "/specification/create")
    public CommonResult<Integer> create(@RequestBody Specifications specifications){
        int i = specificationService.create(specifications);
        if(i>0){
            return new CommonResult<>(200,"添加成功",i);
        }
        return new CommonResult<>(444,"添加失败",i);
    }

    @GetMapping(value = "/specification/findOptionAll")
    public CommonResult<List<Specification>> findOptionAll(){
        List<Specification> optionAll = specificationService.findOptionAll();
        if(optionAll!=null){
            return new CommonResult<>(200,"查询成功",optionAll);
        }
        return new CommonResult<>(444,"查询findOptionAll失败",null);
    }
}
