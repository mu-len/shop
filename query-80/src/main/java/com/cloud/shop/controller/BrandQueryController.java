package com.cloud.shop.controller;

import com.cloud.shop.entitlse.Brand;
import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.service.GoodsFeignService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BrandQueryController {

    @Resource
    private GoodsFeignService brandFeignService;

    @GetMapping(value = "/query/goods/brand/findPageBrandList")
    public CommonResult findPageBrandList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        return brandFeignService.findBrandList(pageNum,pageSize);
    }

    @GetMapping(value = "/query/goods/brand/findPageBrandList/{pageNum}/{pageSize}")
    public CommonResult<List<Brand>> findBrandListTwo(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
        return brandFeignService.findBrandListTwo(pageNum,pageSize);
    }

    @GetMapping(value = "/query/goods/brand/findAllOption")
    public CommonResult<List<Brand>> findAllOption(){
        return brandFeignService.findAllOption();
    }

    @GetMapping(value = "/query/goods/brand/findBrandById")
    public CommonResult findBrandById(@RequestParam("id") Long id) {
        return brandFeignService.findBrandById(id);
    }

    @PostMapping(value = "/query/goods/brand/updateBrand")
    public CommonResult updateBrand(Brand brand) {
        return brandFeignService.updateBrand(brand);
    }

    @PostMapping(value = "/query/goods/brand/createBrand")
    public CommonResult createBrand(Brand brand) {
        return brandFeignService.createBrand(brand);
    }

    @GetMapping(value = "/query/goods/brand/deleteBrand")
    public CommonResult deleteBrand(@RequestParam("id") Long id) {
        return brandFeignService.deleteBrand(id);
    }

    @PostMapping(value = "/query/goods/brand/deleteSelection")
    public CommonResult deleteSelection(Long[] ids){
        return brandFeignService.deleteSelection(ids);
    }

}
