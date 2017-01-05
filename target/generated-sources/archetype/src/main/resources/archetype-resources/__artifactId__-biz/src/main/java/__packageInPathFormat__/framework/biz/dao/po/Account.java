#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.framework.biz.dao.po;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("account")
public class Account {
    private Integer subscribe;	// 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
    private String openid;	//用户的标识，对当前公众号唯一
    private String nickname; //用户的昵称
    private Integer sex;	//用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
    private String city;	//用户所在城市
    private String country;	//用户所在国家
    private String province; //	用户所在省份
    private String language;	//用户的语言，简体中文为zh_CN
    private String headimgurl;	//用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
    private Date subscribe_time;	//用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
    private String unionid;	//只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）
    private String remark;	//公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
    private Integer groupid;	//用户所在的分组ID
    private String mobileNo;  //手机号
    private String email;  //邮箱
    private String industry; //行业
    private String function; //职业
    private String workingLife; //工作年限
    private String realName; //真名
}