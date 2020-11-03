package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.Goods;
import com.cloud.shop.service.GoodsServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.List;

@RestController
public class GoodsController {

    @Resource
    private GoodsServiceImpl goodsService;

    @GetMapping(value = "/goods/findGoodsList")
    public CommonResult<List<Goods>> findGoodsList(Integer pageNum,Integer pageSize){
        List<Goods> goodsList = goodsService.findGoodsList(pageNum,pageSize);
        if(null!=goodsList){
            return new CommonResult<>(200,"查询成功",goodsList);
        }
        return new CommonResult<>(444,"查询findGoodsList失败",null);
    }

    @GetMapping(value = "/goods/findGoodsById")
    public CommonResult<Goods> findGoodsById(Long id){
        Goods goods = goodsService.findGoodsById(id);
        if(null!=goods){
            return new CommonResult<>(200,"查询成功",goods);
        }
        return new CommonResult<>(444,"查询findGoodsById失败，id："+id,null);
    }

    @GetMapping(value = "/goods/findLikeName")
    public CommonResult<List<Goods>> findLikeName(String name){
        List<Goods> likeName = goodsService.findLikeName(name);
        if(null!=likeName){
            return new CommonResult<>(200,"查询成功",likeName);
        }
        return new CommonResult<>(444,"查询findLikeName失败，likeName："+name,null);
    }

    @PostMapping(value = "/goods/deleteGoods")
    public CommonResult<Integer> deleteGoods(@RequestBody Long[] ids){
        int i = goodsService.deleteGoods(ids);
        if(i>0){
            return new CommonResult<>(200,"删除成功",i);
        }
        return new CommonResult<>(444,"删除失败，ids："+ids,i);
    }
}
