package com.cloud.shop.entitlse;

import lombok.Data;

import java.io.Serializable;

@Data
public class SpecificationOption  implements Serializable {

    private Long id;
    private String optionName;
    private Long specId;
    private Long orders;
}
