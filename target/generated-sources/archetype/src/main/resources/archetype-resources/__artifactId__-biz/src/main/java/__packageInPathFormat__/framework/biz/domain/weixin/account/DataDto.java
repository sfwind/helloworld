#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.framework.biz.domain.weixin.account;

import lombok.Data;

import java.util.List;

@Data
public class DataDto {
    private List<String> openid;
}
