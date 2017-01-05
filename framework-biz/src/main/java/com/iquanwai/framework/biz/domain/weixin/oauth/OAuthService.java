package com.iquanwai.framework.biz.domain.weixin.oauth;

public interface OAuthService {
    String ACCESS_TOKEN_COOKIE_NAME = "_act";
    /**
     * 根据accessToken，获取授权用户的openid
     * */
    String openId(String accessToken);
}
