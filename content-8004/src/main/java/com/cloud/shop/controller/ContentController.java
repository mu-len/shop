package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.Content;
import com.cloud.shop.service.ContentServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ContentController {

    @Resource
    private ContentServiceImpl contentService;

    @GetMapping(value = "/content/findContentPageList")
    public CommonResult<List<Content>> findContentPageList(Integer pageNum,Integer pageSize){
        List<Content> contentPageList = contentService.findContentPageList(pageNum, pageSize);
        if(null!=contentPageList){
            return new CommonResult<>(200,"查询成功",contentPageList);
        }
        return new CommonResult<>(444,"查询findContentPageList失败",null);
    }

    @GetMapping(value = "/content/findContentById")
    public CommonResult<Content> findContentById(Long id){
        Content content = contentService.findContentById(id);
        if(null!=content){
            return new CommonResult<>(200,"查询成功",content);
        }
        return new CommonResult<>(444,"查询context失败，id："+id,null);
    }

    @GetMapping(value = "/content/findContentLikeName")
    public CommonResult<List<Content>> findContentLikeName(String name){
        List<Content> contentLike = contentService.findContentLikeName(name);
        if(null!=contentLike){
            return new CommonResult<>(200,"查询成功",contentLike);
        }
        return new CommonResult<>(444,"查询findContentLikeName失败",null);
    }

    @PostMapping(value = "/content/createContent")
    public CommonResult<Integer> createContent(@RequestBody Content content){
        int i = contentService.createContent(content);
        if(i>0){
            return new CommonResult<>(200,"添加content数据成功",i);
        }
        return new CommonResult<>(406,"添加content数据失败，数据："+content,i);
    }

    @PostMapping(value = "/content/updateContent")
    public CommonResult<Integer> updateContent(@RequestBody Content content){
        int i = contentService.updateContent(content);
        if(i>0){
            return new CommonResult<>(200,"修改content数据成功",i);
        }
        return new CommonResult<>(405,"修改content数据失败，数据："+content,i);
    }

    @PostMapping(value = "/content/deleteContents")
    public CommonResult<Integer> deleteContents(@RequestBody Long[] ids){
        int i = contentService.deleteContents(ids);
        if(i>0){
            return new CommonResult<>(200,"删除content数据成功",i);
        }
        return new CommonResult<>(405,"删除content数据失败，ids："+ids,i);
    }

    @PostMapping(value = "/content/upload")
    public CommonResult<Boolean> upload(@RequestBody MultipartFile file){
        boolean upload = contentService.upload(file);
        if(upload){
            return new CommonResult<>(200,"上传成功",true);
        }
        return new CommonResult<>(444,"上传失败",false);
    }

    @PostMapping(value = "/content/download")
    public CommonResult<byte[]> download(@RequestBody String name){
        byte[] download = this.contentService.download(name);
        if(download.length>0){
            return new CommonResult<>(200,"查询成功",download);
        }
        return new CommonResult<>(444,"查询失败",null);
    }

    @GetMapping(value = "/content/textUpload")
    public CommonResult<Boolean> textUpload(){
        boolean b = contentService.textUpload();
        if(b){
            return new CommonResult<>(200,"测试成功",true);
        }
        return new CommonResult<>(444,"测试失败",false);
    }

    @GetMapping(value = "/content/textDownload")
    public CommonResult<Boolean> textDownload(){
        boolean b=contentService.textDownload();
        if(b){
            return new CommonResult<>(200,"测试成功",true);
        }
        return new CommonResult<>(444,"测试失败",false);
    }

}
