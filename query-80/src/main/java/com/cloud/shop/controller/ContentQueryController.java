package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.Content;
import com.cloud.shop.service.ContentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class ContentQueryController {

    @Resource
    private ContentFeignService contentFeignService;

    @GetMapping(value = "/query/content/findContentPageList")
    public CommonResult<List<Content>> findContentPageList(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        return contentFeignService.findContentPageList(pageNum,pageSize);
    }

    @GetMapping(value = "/query/content/findContentById",produces = "application/json;charset=utf-8")
    public CommonResult<Content> findContentById(@RequestParam("id") Long id){
        return contentFeignService.findContentById(id);
    }

    @GetMapping(value = "/query/content/findContentLikeName")
    public CommonResult<List<Content>> findContentLikeName(@RequestParam("name") String name){
        return contentFeignService.findContentLikeName(name);
    }

    @PostMapping(value = "/query/content/createContent")
    public CommonResult<Integer> createContent(Content content){
        return contentFeignService.createContent(content);
    }

    @PostMapping(value = "/query/content/updateContent")
    public CommonResult<Integer> updateContent(Content content){
        return contentFeignService.updateContent(content);
    }

    @PostMapping(value = "/query/content/deleteContents")
    public CommonResult<Integer> deleteContents(Long[] ids){
        return contentFeignService.deleteContents(ids);
    }

    @PostMapping(value = "/query/content/upload")
    public CommonResult<Boolean> upload(MultipartFile file){
        return contentFeignService.upload(file);
    }

    @PostMapping(value = "/query/content/download")
    public CommonResult download(String name, HttpServletResponse response){
        CommonResult<byte[]> download = this.contentFeignService.download(name);
        if(download.getCode()==200){
            try {
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(download.getData());
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                return new CommonResult(444,"传输失败",null);
            }
        }
        return download;
    }

    @GetMapping(value = "/query/content/textUpload")
    public CommonResult<Boolean> textUpload(){
        return contentFeignService.textUpload();
    }

    @GetMapping(value = "/query/content/textDownload")
    public CommonResult<Boolean> textDownload(){
        return contentFeignService.textDownload();
    }

}
