package com.cloud.shop.entitlse;

import lombok.Data;

import java.io.Serializable;

@Data
public class SellerSimple  implements Serializable {
    private String sellerId;
    private String name;
    private String nickName;
    private String linkmanName;
    private String linkmanMobile;
    private String status;
}
