package com.cloud.shop.entitlse;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Specifications  implements Serializable {

    private Specification specification;
    private List<SpecificationOption> specificationOptions;
}
