package com.cloud.shop.controller;

import com.cloud.shop.entitlse.Brand;
import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.service.BrandServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BrandController {

    @Resource
    private BrandServiceImpl brandService;

    @GetMapping(value = "/goods/brand/findPageBrandList")
    public CommonResult<List<Brand>> findBrandList(Integer pageNum, Integer pageSize) {
        List<Brand> pageBrandList = brandService.findPageBrandList(pageNum, pageSize);
        if (null != pageBrandList && pageBrandList.size() > 0) {
            return new CommonResult<>(200, "查询成功", pageBrandList);
        }
        return new CommonResult<>(444, "查询BrandList失败", null);
    }

    @GetMapping(value = "/goods/brand/findPageBrandList/{pageNum}/{pageSize}")
    public CommonResult<List<Brand>> findBrandListTwo(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        List<Brand> pageBrandList = brandService.findPageBrandList(pageNum, pageSize);
        if (null != pageBrandList && pageBrandList.size() > 0) {
            return new CommonResult<>(200, "查询成功", pageBrandList);
        }
        return new CommonResult<>(444, "查询BrandList失败", null);
    }

    @GetMapping(value = "/goods/brand/findBrandById")
    public CommonResult<Brand> findBrandById(Long id) {
        Brand brand = brandService.findBrandById(id);
        if (null != brand) {
            return new CommonResult<>(200, "查询成功", brand);
        }
        return new CommonResult<>(401, "没找到要查询的品牌，id：" + id, null);
    }

    @PostMapping(value = "/goods/brand/updateBrand")
    public CommonResult<Integer> updateBrand(@RequestBody Brand brand) {
        int i = brandService.updateBrand(brand);
        if (i > 0) {
            return new CommonResult<>(200, "修改成功", i);
        }
        return new CommonResult<>(405, "修改品牌信息失败,数据："+brand,i);
    }

    @PostMapping(value = "/goods/brand/createBrand")
    public CommonResult<Integer> createBrand(@RequestBody Brand brand) {
        if(brandService.findIdByName(brand.getName())){
            int i = brandService.createBrand(brand);
            if (i > 0) {
                return new CommonResult<>(200, "添加成功", i);
            }
            return new CommonResult<>(406, "添加品牌信息失败,数据"+brand,i);
        }
        return new CommonResult<>(410,"添加brand信息失败，已存在该brand",null);

    }

    @GetMapping(value = "/goods/brand/deleteBrand")
    public CommonResult<Integer> deleteBrand(Long id) {
        int i = brandService.deleteBrand(id);
        if (i > 0) {
            return new CommonResult<>(200, "删除成功", i);
        }
        return new CommonResult<>(406, "删除品牌信息失败,id:"+id,i);
    }

    @PostMapping(value = "/goods/brand/deleteSelection")
    public CommonResult deleteSelection(@RequestBody Long[] ids){
        int i = brandService.deleteSelection(ids);
        if(i>0){
            return new CommonResult(200,"删除成功",i);
        }
        return new CommonResult(444,"批量删除Brand失败,id："+ids,i);
    }

    @GetMapping(value = "/goods/brand/findAllOption")
    public CommonResult<List<Brand>> findAllOption(){
        List<Brand> allOption = brandService.findAllOption();
        if(allOption!=null){
            return new CommonResult<>(200,"查询成功",allOption);
        }
        return new CommonResult<>(444,"查询findAllOption失败",null);
    }
}
