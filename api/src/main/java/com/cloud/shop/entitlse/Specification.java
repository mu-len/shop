package com.cloud.shop.entitlse;

import lombok.Data;

import java.io.Serializable;

@Data
public class Specification  implements Serializable {

    private Long id;
    private String specName;
}
