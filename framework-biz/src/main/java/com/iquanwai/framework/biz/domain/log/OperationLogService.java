package com.iquanwai.framework.biz.domain.log;


import com.iquanwai.framework.biz.dao.po.OperationLog;

/**
 * Created by justin on 16/9/3.
 */
public interface OperationLogService {

    void log(OperationLog operationLog);
}
