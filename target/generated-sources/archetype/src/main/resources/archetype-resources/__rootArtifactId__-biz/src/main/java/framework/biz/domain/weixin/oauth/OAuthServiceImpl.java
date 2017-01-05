#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.framework.biz.domain.weixin.oauth;

import ${package}.framework.biz.dao.CallbackDao;
import ${package}.framework.biz.dao.po.Callback;
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
