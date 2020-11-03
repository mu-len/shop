package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.ItemCat;
import com.cloud.shop.service.GoodsFeignService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ItemCatQueryController {

    @Resource
    private GoodsFeignService itemCatFeignService;

    @GetMapping(value = "/query/goods/itemCat/findPICPageList")
    public CommonResult<List<ItemCat>> findPICPageList(){
        return itemCatFeignService.findPICPageList();
    }

    @GetMapping(value = "/query/goods/itemCat/findCICPageList")
    public CommonResult<List<ItemCat>> findCICPageList(@RequestParam("id")Long id){
        return itemCatFeignService.findCICPageList(id);
    }

    @GetMapping(value = "/query/goods/itemCat/findICLikeName")
    public CommonResult<List<ItemCat>> findICLikeName(@RequestParam("name") String name){
        return itemCatFeignService.findICLikeName(name);
    }

    @PostMapping(value = "/query/goods/itemCat/createIC")
    public CommonResult<Integer> createIC(ItemCat itemCat){
        return itemCatFeignService.createIC(itemCat);
    }

    @PostMapping(value = "/query/goods/itemCat/updateIC")
    public CommonResult<Integer> updateIC(ItemCat itemCat){
        return itemCatFeignService.updateIC(itemCat);
    }

    @GetMapping(value = "/query/goods/itemCat/deleteIC")
    public CommonResult<Integer> deleteIC(@RequestParam("id") Long id){
        return itemCatFeignService.deleteIC(id);
    }

    @PostMapping(value = "/query/goods/itemCat/deleteICs")
    public CommonResult<Integer> deleteICs(Long[] ids){
        return itemCatFeignService.deleteICs(ids);
    }

    @GetMapping(value = "/query/goods/itemCat/findPageAllList")
    public CommonResult<List<ItemCat>> findPageAllList(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
        System.out.println(pageNum+pageSize);
        return itemCatFeignService.findPageAllList(pageNum,pageSize);
    }
}
