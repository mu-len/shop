package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.service.SellerFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SellerQueryController {

    @Resource
    private SellerFeignService sellerFeignService;

    @GetMapping(value = "/query/sellerSimple/findSeller0SimpleList")
    public CommonResult findSeller0SimpleList() {
        return sellerFeignService.findSeller0SimpleList();
    }

    @GetMapping(value = "/query/sellerSimple/findSellerSimpleList")
    public CommonResult findSellerSimpleList() {
        return sellerFeignService.findSellerSimpleList();
    }

    @GetMapping(value = "/query/sellerSimple/findSS0LikeNANi")
    public CommonResult findSS0LikeNANi(@RequestParam("name") String name, @RequestParam("nickName") String nickName){
        return sellerFeignService.findSS0LikeNANi(name,nickName);
    }

    @GetMapping(value = "/query/sellerSimple/stateChange")
    public CommonResult<Integer> stateChange(@RequestParam("sellerId") String sellerId){
        return sellerFeignService.stateChange(sellerId);
    }

    @GetMapping(value = "/query/sellerDetails/findSellerDetailsById")
    public CommonResult findSellerDetailsById(@RequestParam("id") String id) {
        return sellerFeignService.findSellerDetailsById(id);
    }

    @GetMapping(value = "/query/sellerSimple/findSSLikeNANiByS")
    public CommonResult findSSLikeNANiByS(@RequestParam("name") String name,@RequestParam("nickName") String nickName,@RequestParam("state") Integer state){
        return sellerFeignService.findSSLikeNANiByS(name,nickName,state);
    }

}
