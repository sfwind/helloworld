package com.iquanwai.framework.biz.domain.log;


import com.iquanwai.framework.biz.dao.po.OperationLog;

public interface OperationLogService {

    void log(OperationLog operationLog);
}
