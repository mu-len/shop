package com.cloud.shop.service;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.Content;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient("CLOUD-SHOP-CONTENT")
@Component
public interface ContentFeignService {

    @GetMapping(value = "/content/findContentPageList")
    public CommonResult<List<Content>> findContentPageList(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize);

    @GetMapping(value = "/content/findContentById")
    public CommonResult<Content> findContentById(@RequestParam("id") Long id);

    @GetMapping(value = "/content/findContentLikeName")
    public CommonResult<List<Content>> findContentLikeName(@RequestParam("name") String name);

    @PostMapping(value = "/content/createContent")
    public CommonResult<Integer> createContent(Content content);

    @PostMapping(value = "/content/updateContent")
    public CommonResult<Integer> updateContent(Content content);

    @PostMapping(value = "/content/deleteContents")
    public CommonResult<Integer> deleteContents(Long[] ids);

    @PostMapping(value = "/content/upload")
    public CommonResult<Boolean> upload(MultipartFile file);

    @PostMapping(value = "/content/download")
    public CommonResult<byte[]> download(String name);

    @GetMapping(value = "/content/textUpload")
    public CommonResult<Boolean> textUpload();

    @GetMapping(value = "/content/textDownload")
    public CommonResult<Boolean> textDownload();
}
