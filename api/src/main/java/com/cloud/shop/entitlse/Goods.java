package com.cloud.shop.entitlse;

import lombok.Data;

import java.io.Serializable;

@Data
public class Goods  implements Serializable {

    private Long id;
    private String sellerId;
    private String goodsName;
    private String auditStatus;
    private String caption;
    private Long price;
    private String isDelete;
    private String category1;
    private String category2;
    private String category3;


}
