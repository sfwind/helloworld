#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.biz.domain.weixin.signature;

public interface JsSignatureService {
    JsSignature getJsSignature(String url, boolean refresh);

    String JS_API_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token={access_token}&type=jsapi";
}
