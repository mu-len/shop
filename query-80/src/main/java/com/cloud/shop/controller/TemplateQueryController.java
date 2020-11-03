package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.Template;
import com.cloud.shop.service.GoodsFeignService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TemplateQueryController {

    @Resource
    private GoodsFeignService templateFeignService;

    @GetMapping(value = "/query/goods/template/findTemplatePageList")
    public CommonResult<List<Template>> findTemplatePageList(){
        return templateFeignService.findTemplatePageList();
    }

    @GetMapping(value = "/query/goods/template/findTemplateLikeName")
    public CommonResult<List<Template>> findTemplateLikeName(@RequestParam("name") String name){
        return templateFeignService.findTemplateLikeName(name);
    }

    @GetMapping(value = "/query/goods/template/findTemplateById")
    public CommonResult<Template> findTemplateById(@RequestParam("id") Long id){
        System.out.println(id);
        return templateFeignService.findTemplateById(id);
    }

    @PostMapping(value = "/query/goods/template/createTemplate")
    public CommonResult<Integer> createTemplate(Template template){
        return templateFeignService.createTemplate(template);
    }

    @PostMapping(value = "/query/goods/template/updateTemplate")
    public CommonResult<Integer> updateTemplate(Template template){
        return templateFeignService.updateTemplate(template);
    }

    @GetMapping(value = "/query/goods/template/deleteTemplate")
    public CommonResult<Integer> deleteTemplate(@RequestParam("id") Long id){
        return templateFeignService.deleteTemplate(id);
    }

    @PostMapping(value = "/goods/template/deleteTemplates")
    public CommonResult<Integer> deleteTemplates(Long[] ids){
        return templateFeignService.deleteTemplates(ids);
    }
}
