package com.cloud.shop.entitlse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    private Integer code;
    private String massage;
    private T data;

    public CommonResult(Integer code,String massage){
        this(code,massage,null);
    }

}
