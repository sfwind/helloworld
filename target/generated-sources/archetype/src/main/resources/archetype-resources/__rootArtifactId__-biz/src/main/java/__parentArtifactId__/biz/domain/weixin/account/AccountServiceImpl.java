#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.biz.domain.weixin.account;

import com.google.common.collect.Maps;
import ${package}.${parentArtifactId}.biz.dao.FollowUserDao;
import ${package}.${parentArtifactId}.biz.dao.po.Account;
import ${package}.${parentArtifactId}.biz.util.CommonUtils;
import ${package}.${parentArtifactId}.biz.util.RestfulHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    public RestfulHelper restfulHelper;
    @Autowired
    private FollowUserDao followUserDao;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public Account getAccount(String openid, boolean realTime) {
        //从数据库查询account对象
        Account account = followUserDao.queryByOpenid(openid);
        if(!realTime && account != null) {
            return account;
        }

        return getAccountFromWeixin(openid, account);
    }

    private Account getAccountFromWeixin(String openid, Account account) {
        //调用api查询account对象
        String url = USER_INFO_URL;
        Map<String, String> map = Maps.newHashMap();
        map.put("openid", openid);
        url = CommonUtils.placeholderReplace(url, map);

        String body = restfulHelper.get(url);
        Map<String, Object> result = CommonUtils.jsonToMap(body);
        Account accountNew = new Account();
        try {
            ConvertUtils.register(new Converter() {
                public Object convert(Class aClass, Object value) {
                    if (value == null)
                        return null;

                    if (!(value instanceof Double)) {
                        logger.error("不是日期类型");
                        throw new ConversionException("不是日期类型");
                    }
                    Double time = (Double) value * 1000;

                    return new DateTime(time.longValue()).toDate();
                }
            }, Date.class);

            BeanUtils.populate(accountNew, result);
            //去除昵称里的表情
            accountNew.setNickname(accountNew.getNickname());
            if(account==null) {
                followUserDao.insert(accountNew);
            }else{
                followUserDao.updateMeta(accountNew);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return accountNew;
    }


}
