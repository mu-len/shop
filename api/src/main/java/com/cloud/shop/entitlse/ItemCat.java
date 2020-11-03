package com.cloud.shop.entitlse;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemCat  implements Serializable {

    private Long id;
    private Long parentId;
    private String name;
    private Long typeId;
}
