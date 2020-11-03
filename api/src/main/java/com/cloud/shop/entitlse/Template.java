package com.cloud.shop.entitlse;

import lombok.Data;

import java.io.Serializable;

@Data
public class Template  implements Serializable {

    private Long id;
    private String name;
    private String specIds;
    private String brandIds;
    private String items;
}
