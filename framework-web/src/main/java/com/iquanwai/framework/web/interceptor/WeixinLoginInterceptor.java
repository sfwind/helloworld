package com.iquanwai.framework.web.interceptor;

import com.iquanwai.framework.biz.domain.weixin.oauth.OAuthService;
import com.iquanwai.framework.biz.util.ConfigUtils;
import com.iquanwai.framework.web.util.CookieUtils;
import com.iquanwai.framework.web.util.WebUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WeixinLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!ConfigUtils.isDebug()) {
            // 前端debug开启时,不校验
            if(request.getParameter("debug")!=null && ConfigUtils.isFrontDebug()){
                return true;
            }
            String value = CookieUtils.getCookie(request, OAuthService.ACCESS_TOKEN_COOKIE_NAME);
            //没有access_token,跳转去授权
            if (StringUtils.isEmpty(value)) {
                WebUtils.auth(request, response);
                return false;
            }
        }
        return true;

    }

}
