package com.iquanwai.helloworld.biz.dao.po;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("callback")
public class Callback {
    private String callbackUrl;
    private String state;
    private String accessToken;
    private String refreshToken;
    private String openid;
}
