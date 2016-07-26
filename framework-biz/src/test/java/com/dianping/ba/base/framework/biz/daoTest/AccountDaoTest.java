package com.dianping.ba.base.framework.biz.daoTest;

import com.dianping.ba.base.framework.biz.TestBase;
import com.dianping.ba.base.framework.biz.dao.AccountDao;
import com.dianping.ba.base.framework.biz.dao.po.AccountPO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by qianyuhang on 7/15/15.
 */
public class AccountDaoTest extends TestBase {
    @Autowired
    private AccountDao accountDao;

    @Test
    public void query(){
        AccountPO accountPO = new AccountPO();
        accountPO.setEmployeeNumber("0009562");
        System.out.println(accountDao.query(accountPO));
    }
}
