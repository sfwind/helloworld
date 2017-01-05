package com.iquanwai.helloworld.biz.domain.log;


import com.iquanwai.helloworld.biz.dao.po.OperationLog;

public interface OperationLogService {

    void log(OperationLog operationLog);
}
