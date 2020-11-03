package com.cloud.shop.entitlse;

import lombok.Data;

import java.io.Serializable;

@Data
public class Content  implements Serializable {

    private Long id;
    private String name;
    private String title;
    private String url;
    private String pic;
    private Long status;
    private Long sortOrder;
}
