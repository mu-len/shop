package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.SellerDetails;
import com.cloud.shop.service.SellerDetailsServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SellerDetailsController {

    @Resource
    private SellerDetailsServiceImpl sellerDetailsService;

    @GetMapping(value = "sellerDetails/findSellerDetailsById")
    public CommonResult<SellerDetails> findSellerDetailsById(String id){
        SellerDetails sellerDetails = sellerDetailsService.findSellerDetailsById(id);
        if(null!=sellerDetails){
            return new CommonResult<>(200,"查询成功",sellerDetails);
        }
        return new CommonResult<>(401,"查询失败，查询id："+id,null);
    }
}
