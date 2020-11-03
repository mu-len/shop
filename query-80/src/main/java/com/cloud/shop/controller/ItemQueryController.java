package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.Item;
import com.cloud.shop.service.GoodsFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ItemQueryController {

    @Resource
    private GoodsFeignService itemFeignService;

    @GetMapping(value = "/query/item/findPageItemList")
    public CommonResult<List<Item>> findPageItemList(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize){
        return itemFeignService.findPageItemList(pageNum,pageSize);
    }

    @GetMapping(value = "/query/item/imps")
    public CommonResult<String> imps(){
        return itemFeignService.imps();
    }

    @GetMapping(value = "/query/item/condition")
    public CommonResult<List<Item>> findConditionItem(@RequestParam("title") String title){
        return itemFeignService.findConditionItem(title);
    }


}
