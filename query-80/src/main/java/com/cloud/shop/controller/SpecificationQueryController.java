package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.Specification;
import com.cloud.shop.entitlse.SpecificationOption;
import com.cloud.shop.entitlse.Specifications;
import com.cloud.shop.service.GoodsFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SpecificationQueryController {

    @Resource
    private GoodsFeignService specificationFeignService;

    @GetMapping(value = "/query/specification/findSpList")
    public CommonResult<List<Specification>> findSpList(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
        return specificationFeignService.findSpList(pageNum,pageSize);
    }

    @GetMapping(value = "/query/specification/findSpOpListBySpId")
    public CommonResult<Specifications> findSpOpListBySpId(@RequestParam("id") Long id){
        return specificationFeignService.findSpOpListBySpId(id);
    }

    @GetMapping(value = "/query/specification/findSpLikeName")
    public CommonResult<List<Specification>> findSpLikeName(@RequestParam("specName") String specName){
        return specificationFeignService.findSpLikeName(specName);
    }

    @PostMapping(value = "/query/specification/createSp")
    public CommonResult<Integer> createSp(Specification specification){
        return specificationFeignService.createSp(specification);
    }

    @PostMapping(value = "/query/specification/createSpOp")
    public CommonResult<Integer> createSpOp(SpecificationOption specificationOption){
        return specificationFeignService.createSpOp(specificationOption);
    }

    @PostMapping(value = "/query/specification/updateSp")
    public CommonResult<Integer> updateSp(Specification specification){
        return specificationFeignService.updateSp(specification);
    }

    @PostMapping(value = "/query/specification/updateSpOp")
    public CommonResult<Integer> updateSpOp(SpecificationOption specificationOption){
        return specificationFeignService.updateSpOp(specificationOption);
    }

    @GetMapping(value = "/query/specification/deleteSp")
    public CommonResult<Integer> deleteSp(@RequestParam("ids") Long[] ids){
        return specificationFeignService.deleteSp(ids);
    }

    @GetMapping(value = "/query/specification/deleteSpOp")
    public CommonResult<Integer> deleteSpOp(@RequestParam("id") Long id){
        return specificationFeignService.deleteSpOp(id);
    }

    @PostMapping(value = "/query/specification/create")
    public CommonResult<Integer> create(Specifications specifications){
        return specificationFeignService.create(specifications);
    }

    @GetMapping(value = "/query/specification/findOptionAll")
    public CommonResult<List<Specification>> findOptionAll(){
        return specificationFeignService.findOptionAll();
    }
}
