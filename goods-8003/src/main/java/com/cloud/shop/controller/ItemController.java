package com.cloud.shop.controller;

import com.cloud.shop.entitlse.CommonResult;
import com.cloud.shop.entitlse.Item;
import com.cloud.shop.service.ItemServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.omg.CORBA.COMM_FAILURE;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ItemController {

    @Resource
    private ItemServiceImpl itemService;

    @Resource
    private SolrTemplate solrTemplate;

    @GetMapping(value = "/item/findPageItemList")
    public CommonResult<List<Item>> findPageItemList(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        SimpleQuery simpleQuery=new SimpleQuery("*:*");
        Page<Item> page = solrTemplate.query("collection1", simpleQuery, Item.class);
        PageInfo<Item> pageInfo=new PageInfo<>(page.toList());
        return new CommonResult<>(200,"查询成功",pageInfo.getList());
    }

    @GetMapping(value = "/item/imps")
    public CommonResult<String> imps(){
        List<Item> allItem = itemService.findAllItem();
        solrTemplate.saveBeans("collection1",allItem);
        try{
            solrTemplate.commit("collection1");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("导入失败");
            return new CommonResult<>(444,"导入数据失败");
        }
        return new CommonResult<>(200,"导入数据成功");
    }

    @GetMapping(value = "/item/condition")
    public CommonResult<List<Item>> findConditionItem(String title){
        SimpleQuery simpleQuery=new SimpleQuery();
        Criteria criteria=new Criteria("item_title").endsWith(title);
        simpleQuery.addCriteria(criteria);
        simpleQuery.setRows(10);
        Page<Item> page = this.solrTemplate.query("collection1", simpleQuery, Item.class);
        return new CommonResult<>(200,"查询成功",page.toList());
    }

    @PostMapping(value = "/item/createItem")
    public CommonResult<Integer> createItem(@RequestBody Item item){
        int item1 = itemService.createItem(item);
        if(item1>0){
            return new CommonResult<>(200,"添加数据成功",item1);
        }
        return new CommonResult<>(444,"添加数据失败",item1);
    }

    @GetMapping(value = "/item/deleteItem")
    public CommonResult<Integer> deleteItem(Long id){
        int i = itemService.deleteItem(id);
        if(i>0){
            return new CommonResult<>(200,"删除数据成功",i);
        }
        return new CommonResult<>(444,"删除数据失败",i);
    }

}
