package com.cloud.shop.service;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "CLOUD-SHOP-CERTIFICATION")
@Component
public interface CertificationFeignService {

    @GetMapping(value = "/certification/login/{U}/{P}")
    public CommonResult<User> findUserByUAndP(@PathVariable("U") String username, @PathVariable("P") String password);

    @GetMapping(value = "/certification/findUserById")
    public CommonResult<User> findUserById(@RequestParam("id") Long id);

    @PostMapping(value = "/certification/create")
    public CommonResult createUser(User user);

    @GetMapping(value = "/certification/findUserByName")
    public User findUserByName(@RequestParam("name") String name);

    @RequestMapping(value = "/certification/forbidden")
    public CommonResult forbidden();
}
