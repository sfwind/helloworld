package com.iquanwai.framework.biz.domain.weixin.account;


import com.iquanwai.framework.biz.dao.po.Account;

public interface AccountService {
    /**
     * 根据openid获取用户的详细信息
     * */
    Account getAccount(String openid, boolean realTime);

    String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token={access_token}&openid={openid}&lang=zh_CN";

}
