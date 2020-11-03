package com.cloud.shop.entitlse;

import lombok.Data;

import java.io.Serializable;

@Data
public class SellerDetails  implements Serializable {

    private String sellerId;//公司id
    private String name;//公司名称
    private String mobile;//公司手机
    private String telephone;//公司电话
    private String status;//审核状态
    private String addressDetail;//详细地址
    private String linkmanName;//联系人名字
    private String linkmanQq;//联系人qq
    private String linkmanMobile;//联系人电话
    private String linkmanEmail;//联系人邮箱
    private String licenseNumber;//营业执照号
    private String taxNumber;//税务登记证号
    private String orgNumber;//组织机构代码证号
    private String legalPerson;//法定代表人
    private String legalPersonCardId;//法定代表人身份证
    private String bankUser;//银行账户
    private String bankName;//开户银行名称

}
