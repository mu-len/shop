package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.User;
import com.cloud.shop.service.CertificationFeignService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class CertificationQueryController {

    @Resource
    private CertificationFeignService certificationFeignService;

    @GetMapping(value = "/query/certification/login/{U}/{P}")
    public CommonResult findUserByUAndP(@PathVariable("U") String username, @PathVariable("P") String password) {
        return certificationFeignService.findUserByUAndP(username,password);
    }

    @GetMapping(value = "/query/certification/findUserById")
    public CommonResult findUserById(@RequestParam("id") Long id) {
        return certificationFeignService.findUserById(id);
    }

    @PostMapping("/query/certification/create")
    public CommonResult createUser(User user) {
        return certificationFeignService.createUser(user);
    }
}
