package com.iquanwai.helloworld.biz.domain.weixin.account;

import lombok.Data;

@Data
public class UsersDto {
    private Integer total;
    private Integer count;
    private DataDto data;
    private String next_openid;
}
