package com.iquanwai.helloworld.biz.domain.log;

import com.iquanwai.helloworld.biz.dao.OperationLogDao;
import com.iquanwai.helloworld.biz.dao.po.OperationLog;
import com.iquanwai.helloworld.biz.util.ConfigUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    private OperationLogDao operationLogDao;

    public void log(OperationLog operationLog) {
        if(ConfigUtils.logSwitch()) {
            operationLogDao.insert(operationLog);
        }
    }
}
