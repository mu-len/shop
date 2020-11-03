package com.cloud.shop.entitlse;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.Dynamic;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Data
public class Item implements Serializable{
	
	@Field("item_id")
    private Long id;

	@Field("item_title")
    private String title;

	@Field("item_sell_point")
    private String sellPoint;

    @Field("item_price")
    private Double price;

    private Integer stockCount;

    private Integer num;

    private String barcode;

    @Field("item_image")
    private String image;

    @Field("item_category_name")
    private Long categoryid;

    private String status;

    private Date createTime;

    private Date updateTime;

    private String itemSn;

    private Double costPirce;

    private Double marketPrice;

    private String isDefault;

    @Field("item_goodsid")
    private Long goodsId;

    private String sellerId;

    private String cartThumbnail;

    @Field("item_category")
    private String category;

    @Field("item_brand")
    private String brand;

    private String spec;

    @Field("item_seller")
    private String seller;
    
    @Dynamic
    @Field("item_spec_*")
    private Map<String,String> specMap;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}