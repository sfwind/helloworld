#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.biz.domain.weixin.signature;

import ${package}.biz.util.CommonUtils;
import ${package}.biz.util.ConfigUtils;
import ${package}.biz.util.RestfulHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class JsSignatureServiceImpl implements JsSignatureService {
    @Autowired
    private RestfulHelper restfulHelper;

    private String jsapi_ticket;

    private final static Object LOCK = new Object();

    private long last_update = 0;

    private Logger logger = LoggerFactory.getLogger(JsSignatureServiceImpl.class);

    public JsSignature getJsSignature(String url, boolean refresh) {
        //判断是否超过间隔
        int interval = ConfigUtils.getJsSignatureInterval();
        long now = new Date().getTime();
        if(now - last_update > interval*1000){
            synchronized (LOCK) {
                if((now - last_update > interval*1000)) {
                    // refresh
                    refreshJsApiTicket();
                    logger.info("refresh js ticket now, new jsticket is {}", jsapi_ticket);
                    this.last_update = now;
                }
            }
        }

        String noncestr = CommonUtils.randomString(11);
        String timestamp =  Long.toString(System.currentTimeMillis()/1000);
        Map<String, String> vars = new LinkedHashMap<String, String>();
        vars.put("jsapi_ticket", jsapi_ticket);
        logger.info("jsapi_ticket {}", jsapi_ticket);
        vars.put("noncestr", noncestr);
        vars.put("timestamp", timestamp);
        vars.put("url", url);
        String signature = CommonUtils.jsSign(vars);
        return new JsSignature(ConfigUtils.getAppid(),
                timestamp, noncestr, signature);
    }

    private void refreshJsApiTicket() {
        String body = restfulHelper.get(JS_API_URL);

        Map<String, Object> result = CommonUtils.jsonToMap(body);
        this.jsapi_ticket = (String)result.get("ticket");
    }

}