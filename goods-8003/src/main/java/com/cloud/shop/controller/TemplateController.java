package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.Template;
import com.cloud.shop.service.TemplateService;
import com.cloud.shop.service.TemplateServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TemplateController {

    @Resource
    private TemplateServiceImpl templateService;

    @GetMapping(value = "/goods/template/findTemplatePageList")
    public CommonResult<List<Template>> findTemplatePageList(){
        List<Template> templatePageList = templateService.findTemplatePageList();
        if(templatePageList!=null){
            return new CommonResult<>(200,"查询成功",templatePageList);
        }
        return new CommonResult<>(444,"查询findTemplatePageList失败",null);
    }

    @GetMapping(value = "/goods/template/findTemplateLikeName")
    public CommonResult<List<Template>> findTemplateLikeName(String name){
        List<Template> templateList = templateService.findTemplateLikeName(name);
        if(templateList!=null){
            return new CommonResult<>(200,"查询成功",templateList);
        }
        return new CommonResult<>(444,"查询findTemplateLikeName失败,查询条件："+name,null);
    }

    @GetMapping(value = "/goods/template/findTemplateById")
    public CommonResult<Template> findTemplateById(Long id){
        Template template = templateService.findTemplateById(id);
        if(template!=null){
            return new CommonResult<>(200,"查询成功",template);
        }
        return new CommonResult<>(444,"查询失败，id："+id,null);
    }

    @PostMapping(value = "/goods/template/createTemplate")
    public CommonResult<Integer> createTemplate(@RequestBody Template template){
        int i = templateService.createTemplate(template);
        if(i>0){
            return new CommonResult<>(200,"添加Template数据成功",i);
        }
        return new CommonResult<>(406,"添加Template数据失败,数据："+template,i);
    }

    @PostMapping(value = "/goods/template/updateTemplate")
    public CommonResult<Integer> updateTemplate(@RequestBody Template template){
        int i = templateService.updateTemplate(template);
        if(i>0){
            return new CommonResult<>(200,"修改Template数据成功",i);
        }
        return new CommonResult<>(405,"修改Template数据失败，数据："+template,i);
    }

    @GetMapping(value = "/goods/template/deleteTemplate")
    public CommonResult<Integer> deleteTemplate(Long id){
        int i = templateService.deleteTemplate(id);
        if(i>0){
            return new CommonResult<>(200,"删除Template数据成功",i);
        }
        return new CommonResult<>(444,"删除Template数据失败,id："+id,i);
    }

    @PostMapping(value = "/goods/template/deleteTemplates")
    public CommonResult<Integer> deleteTemplates(@RequestBody Long[] ids){
        int i = templateService.deleteTemplates(ids);
        if(i>0){
            return new CommonResult<>(200,"删除Template数据成功",i);
        }
        return new CommonResult<>(444,"删除Template数据失败,id："+ids,i);
    }
}
