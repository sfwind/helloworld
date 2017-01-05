package com.iquanwai.helloworld.biz.domain.weixin.oauth;

import com.iquanwai.helloworld.biz.dao.CallbackDao;
import com.iquanwai.helloworld.biz.dao.po.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OAuthServiceImpl implements OAuthService {
    @Autowired
    private CallbackDao callbackDao;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public String openId(String accessToken) {
        if(accessToken==null){
            return null;
        }
        Callback callback = callbackDao.queryByAccessToken(accessToken);
        if(callback==null){
            logger.error("accessToken {} is invalid", accessToken);
            return null;
        }
        return callback.getOpenid();
    }

}