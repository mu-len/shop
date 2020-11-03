package com.cloud.shop.service;

import com.cloud.shop.entitlse.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "CLOUD-SHOP-GOODS")
@Component
public interface GoodsFeignService {

    @GetMapping(value = "/goods/brand/findPageBrandList")
    public CommonResult<List<Brand>> findBrandList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @GetMapping(value = "/goods/brand/findPageBrandList/{pageNum}/{pageSize}")
    public CommonResult<List<Brand>> findBrandListTwo(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize);

    @GetMapping(value = "/goods/brand/findAllOption")
    public CommonResult<List<Brand>> findAllOption();

    @GetMapping(value = "/goods/brand/findBrandById")
    public CommonResult<Brand> findBrandById(@RequestParam(value = "id") Long id);

    @PostMapping(value = "/goods/brand/updateBrand")
    public CommonResult<Integer> updateBrand(Brand brand);

    @PostMapping(value = "/goods/brand/createBrand")
    public CommonResult<Integer> createBrand(Brand brand);

    @GetMapping(value = "/goods/brand/deleteBrand")
    public CommonResult<Integer> deleteBrand(@RequestParam("id") Long id);

    @PostMapping(value = "/goods/brand/deleteSelection")
    public CommonResult deleteSelection(Long[] ids);

    @GetMapping(value = "/specification/findSpList")
    public CommonResult<List<Specification>> findSpList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize);

    @GetMapping(value = "/specification/findSpOpListBySpId")
    public CommonResult<Specifications> findSpOpListBySpId(@RequestParam("id") Long id);

    @GetMapping(value = "/specification/findSpLikeName")
    public CommonResult<List<Specification>> findSpLikeName(@RequestParam("specName") String specName);

    @PostMapping(value = "/specification/createSp")
    public CommonResult<Integer> createSp(Specification specification);

    @PostMapping(value = "/specification/createSpOp")
    public CommonResult<Integer> createSpOp(SpecificationOption specificationOption);

    @PostMapping(value = "/specification/updateSp")
    public CommonResult<Integer> updateSp(Specification specification);

    @PostMapping(value = "/specification/updateSpOp")
    public CommonResult<Integer> updateSpOp(SpecificationOption specificationOption);

    @GetMapping(value = "/specification/deleteSp")
    public CommonResult<Integer> deleteSp(@RequestParam("ids") Long[] ids);

    @GetMapping(value = "/specification/deleteSpOp")
    public CommonResult<Integer> deleteSpOp(@RequestParam("id") Long id);

    @PostMapping(value = "/specification/create")
    public CommonResult<Integer> create(Specifications specifications);

    @GetMapping(value = "/specification/findOptionAll")
    public CommonResult<List<Specification>> findOptionAll();

    @GetMapping(value = "/goods/itemCat/findPICPageList")
    public CommonResult<List<ItemCat>> findPICPageList();

    @GetMapping(value = "/goods/itemCat/findCICPageList")
    public CommonResult<List<ItemCat>> findCICPageList(@RequestParam("id") Long id);

    @GetMapping(value = "/goods/itemCat/findICLikeName")
    public CommonResult<List<ItemCat>> findICLikeName(@RequestParam("name") String name);

    @PostMapping(value = "/goods/itemCat/createIC")
    public CommonResult<Integer> createIC(ItemCat itemCat);

    @PostMapping(value = "/goods/itemCat/updateIC")
    public CommonResult<Integer> updateIC(ItemCat itemCat);

    @GetMapping(value = "/goods/itemCat/deleteIC")
    public CommonResult<Integer> deleteIC(@RequestParam("id") Long id);

    @PostMapping(value = "/goods/itemCat/deleteICs")
    public CommonResult<Integer> deleteICs(Long[] ids);

    @GetMapping(value = "/goods/itemCat/findPageAllList")
    public CommonResult<List<ItemCat>> findPageAllList(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize);

    @GetMapping(value = "/goods/template/findTemplatePageList")
    public CommonResult<List<Template>> findTemplatePageList();

    @GetMapping(value = "/goods/template/findTemplateLikeName")
    public CommonResult<List<Template>> findTemplateLikeName(@RequestParam("name") String name);

    @GetMapping(value = "/goods/template/findTemplateById")
    public CommonResult<Template> findTemplateById(@RequestParam("id") Long id);

    @PostMapping(value = "/goods/template/createTemplate")
    public CommonResult<Integer> createTemplate(Template template);

    @PostMapping(value = "/goods/template/updateTemplate")
    public CommonResult<Integer> updateTemplate(Template template);

    @GetMapping(value = "/goods/template/deleteTemplate")
    public CommonResult<Integer> deleteTemplate(@RequestParam("id") Long id);

    @PostMapping(value = "/goods/template/deleteTemplates")
    public CommonResult<Integer> deleteTemplates(Long[] ids);

    @GetMapping(value = "/goods/findGoodsList")
    public CommonResult<List<Goods>> findGoodsList(@RequestParam("pageNum")Integer pageNum,@RequestParam("pageSize")Integer pageSize);

    @GetMapping(value = "/goods/findGoodsById")
    public CommonResult<Goods> findGoodsById(@RequestParam("id") Long id);

    @GetMapping(value = "/goods/findLikeName")
    public CommonResult<List<Goods>> findLikeName(@RequestParam("name") String name);

    @PostMapping(value = "/goods/deleteGoods")
    public CommonResult<Integer> deleteGoods(Long[] ids);

    @GetMapping(value = "/item/findPageItemList")
    public CommonResult<List<Item>> findPageItemList(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize);

    @GetMapping(value = "/item/imps")
    public CommonResult<String> imps();

    @GetMapping(value = "/item/condition")
    public CommonResult<List<Item>> findConditionItem(@RequestParam("title") String title);
}
