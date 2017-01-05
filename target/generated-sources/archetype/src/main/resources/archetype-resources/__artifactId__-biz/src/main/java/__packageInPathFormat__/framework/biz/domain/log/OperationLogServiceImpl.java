#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.framework.biz.domain.log;

import ${package}.framework.biz.dao.OperationLogDao;
import ${package}.framework.biz.dao.po.OperationLog;
import ${package}.framework.biz.util.ConfigUtils;
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
