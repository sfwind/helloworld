#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.framework.biz.domain.weixin.accessToken;


public interface AccessTokenService {
    String getAccessToken();

    String refreshAccessToken();
}
