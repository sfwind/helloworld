#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.biz.domain.weixin.account;


import ${package}.biz.dao.po.Account;

public interface AccountService {
    /**
     * 根据openid获取用户的详细信息
     * */
    Account getAccount(String openid, boolean realTime);

    String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token={access_token}&openid={openid}&lang=zh_CN";

}
