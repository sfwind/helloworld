package com.iquanwai.helloworld.biz.domain.weixin.signature;

public interface JsSignatureService {
    JsSignature getJsSignature(String url, boolean refresh);

    String JS_API_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token={access_token}&type=jsapi";
}
