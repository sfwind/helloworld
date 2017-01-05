package com.iquanwai.helloworld.biz.domain.weixin.accessToken;


public interface AccessTokenService {
    String getAccessToken();

    String refreshAccessToken();
}
