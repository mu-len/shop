package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.Goods;
import com.cloud.shop.service.GoodsFeignService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class GoodsController {

    @Resource
    private GoodsFeignService goodsFeignService;

    @GetMapping(value = "/query/goods/findGoodsList")
    public CommonResult<List<Goods>> findGoodsList(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
        return goodsFeignService.findGoodsList(pageNum,pageSize);
    }

    @GetMapping(value = "/query/goods/findGoodsById")
    public CommonResult<Goods> findGoodsById(@RequestParam("id") Long id){
        return goodsFeignService.findGoodsById(id);
    }

    @GetMapping(value = "/query/goods/findLikeName")
    public CommonResult<List<Goods>> findLikeName(@RequestParam("name") String name){
        return goodsFeignService.findLikeName(name);
    }

    @PostMapping(value = "/query/goods/deleteGoods")
    public CommonResult<Integer> deleteGoods(Long[] ids){
        return goodsFeignService.deleteGoods(ids);
    }


}
