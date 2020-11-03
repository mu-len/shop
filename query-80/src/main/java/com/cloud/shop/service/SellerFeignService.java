package com.cloud.shop.service;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.SellerDetails;
import com.cloud.shop.entitlse.SellerSimple;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "CLOUD-SHOP-SELLER")
@Component
public interface SellerFeignService {

    @GetMapping(value = "sellerDetails/findSellerDetailsById")
    public CommonResult<SellerDetails> findSellerDetailsById(@RequestParam("id") String id);

    @GetMapping(value = "/sellerSimple/findSeller0SimpleList")
    public CommonResult<List<SellerSimple>> findSeller0SimpleList();

    @GetMapping(value = "/sellerSimple/findSellerSimpleList")
    public CommonResult<List<SellerSimple>> findSellerSimpleList();

    @GetMapping(value = "/sellerSimple/stateChange")
    public CommonResult<Integer> stateChange(@RequestParam("sellerId") String sellerId);

    @GetMapping(value = "/sellerSimple/findSS0LikeNANi")
    public CommonResult<List<SellerSimple>> findSS0LikeNANi(@RequestParam("name") String name,@RequestParam("nickName") String nickName);

    @GetMapping(value = "/sellerSimple/findSSLikeNANiByS")
    public CommonResult<List<SellerSimple>> findSSLikeNANiByS(@RequestParam("name") String name,@RequestParam("nickName") String nickName,@RequestParam("state") Integer state);


}
