package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.ItemCat;
import com.cloud.shop.service.ItemCatServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ItemCatController {

    @Resource
    private ItemCatServiceImpl itemCatService;

    @GetMapping(value = "/goods/itemCat/findPICPageList")
    public CommonResult<List<ItemCat>> findPICPageList(){
        List<ItemCat> picPageList = itemCatService.findPICPageList();
        if(picPageList!=null){
            return new CommonResult<>(200,"查询成功",picPageList);
        }
        return new CommonResult<>(444,"查询findPICPageList失败",null);
    }

    @GetMapping(value = "/goods/itemCat/findCICPageList")
    public CommonResult<List<ItemCat>> findCICPageList(Long id){
        List<ItemCat> cicPageList = itemCatService.findCICPageList(id);
        if(cicPageList!=null){
            return new CommonResult<>(200,"查询成功",cicPageList);
        }
        return new CommonResult<>(444,"查询findCICPageList失败，id："+id,null);
    }

    @GetMapping(value = "/goods/itemCat/findICLikeName")
    public CommonResult<List<ItemCat>> findICLikeName(String name){
        List<ItemCat> icLikeName = itemCatService.findICLikeName(name);
        if(icLikeName!=null){
            return new CommonResult<>(200,"查询成功",icLikeName);
        }
        return new CommonResult<>(444,"查询findICLikeName失败，name："+name,null);
    }

    @PostMapping(value = "/goods/itemCat/createIC")
    public CommonResult<Integer> createIC(@RequestBody ItemCat itemCat){
        int ic = itemCatService.createIC(itemCat);
        if(ic>0){
            return new CommonResult<>(200,"添加ItemCat数据成功",ic);
        }
        return new CommonResult<>(406,"添加ItemCat数据失败，数据："+itemCat,ic);
    }

    @PostMapping(value = "/goods/itemCat/updateIC")
    public CommonResult<Integer> updateIC(@RequestBody ItemCat itemCat){
        int i = itemCatService.updateIC(itemCat);
        if(i>0){
            return new CommonResult<>(200,"修改ItemCat数据成功",i);
        }
        return new CommonResult<>(405,"修改ItemCat数据失败，数据："+itemCat,i);
    }

    @GetMapping(value = "/goods/itemCat/deleteIC")
    public CommonResult<Integer> deleteIC(Long id){
        int i = itemCatService.deleteIC(id);
        if(i>0){
            return new CommonResult<>(200,"删除ItemCat数据成功",i);
        }
        return new CommonResult<>(405,"删除ItemCat数据失败，id："+id,i);
    }

    @PostMapping(value = "/goods/itemCat/deleteICs")
    public CommonResult<Integer> deleteICs(@RequestBody Long[] ids){
        int i = itemCatService.deleteICs(ids);
        if(i>0){
            return new CommonResult<>(200,"删除ItemCat数据成功",i);
        }
        return new CommonResult<>(405,"删除ItemCat数据失败，id："+ids,i);
    }

    @GetMapping(value = "/goods/itemCat/findPageAllList")
    public CommonResult<List<ItemCat>> findPageAllList(Integer pageNum,Integer pageSize){
        System.out.println(pageNum+pageSize);
        List<ItemCat> pageAllList = itemCatService.findPageAllList(pageNum, pageSize);
        if(null!=pageAllList){
            return new CommonResult<>(200,"查询成功",pageAllList);
        }
        return new CommonResult<>(444,"查询findPageAllList失败，pageNum："+pageNum+"，pageSize："+pageSize,null);
    }
}
