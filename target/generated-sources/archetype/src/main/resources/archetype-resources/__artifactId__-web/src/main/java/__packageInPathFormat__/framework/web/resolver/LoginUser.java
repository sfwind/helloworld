#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.framework.web.resolver;

import ${package}.framework.biz.util.ConfigUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser {
    private String openId;
    private String weixinName;
    private String headimgUrl;
    private String realName;

    public static LoginUser defaultUser(){
        return new LoginUser(ConfigUtils.getDefaultOpenid(),"风之伤", null, null);
    }
}