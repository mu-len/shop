package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.SellerSimple;
import com.cloud.shop.service.SellerSimpleServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class SellerSimpleController {

    @Resource
    private SellerSimpleServiceImpl sellerService;

    @GetMapping(value = "/sellerSimple/findSeller0SimpleList")
    public CommonResult<List<SellerSimple>> findSeller0SimpleList(){
        List<SellerSimple> seller0SimpleList = sellerService.findSeller0SimpleList();
        if(null!=seller0SimpleList){
            return new CommonResult<>(200,"查询成功",seller0SimpleList);
        }
        return new CommonResult<>(444,"查询seller0List失败",null);
    }

    @GetMapping(value = "/sellerSimple/findSellerSimpleList")
    public CommonResult<List<SellerSimple>> findSellerSimpleList(){
        List<SellerSimple> sellerSimpleList = sellerService.findSellerSimpleList();
        if(null!=sellerSimpleList){
            return new CommonResult<>(200,"查询成功",sellerSimpleList);
        }
        return new CommonResult<>(444,"查询sellerList失败",sellerSimpleList);
    }

    @GetMapping(value = "/sellerSimple/stateChange")
    public CommonResult<Integer> stateChange(String sellerId){
        int i = sellerService.stateChange(sellerId);
        if(i>0){
            return new CommonResult<>(200,"审核通过，状态变更成功",i);
        }
        return new CommonResult<>(405,"状态变更失败，审核id："+sellerId,null);
    }

    @GetMapping(value = "/sellerSimple/findSS0LikeNANi")
    public CommonResult<List<SellerSimple>> findSS0LikeNANi(String name, String nickName){
        List<SellerSimple> sellerSimple = sellerService.findSS0LikeNANi(name, nickName);
        if(null!=sellerSimple){
            return new CommonResult<>(200,"查询成功",sellerSimple);
        }
        return new CommonResult<>(444,"查询失败，查询条件："+name+","+nickName,null);
    }

    @GetMapping(value = "/sellerSimple/findSSLikeNANiByS")
    public CommonResult<List<SellerSimple>> findSSLikeNANiByS(String name, String nickName, Integer state){
        List<SellerSimple> ssLikeNANiByS = sellerService.findSSLikeNANiByS(name, nickName, state);
        if(null!=ssLikeNANiByS){
            return new CommonResult<>(200,"查询成功",ssLikeNANiByS);
        }
        return new CommonResult<>(444,"查询失败，查询条件："+name+","+nickName+","+state,null);
    }

}
