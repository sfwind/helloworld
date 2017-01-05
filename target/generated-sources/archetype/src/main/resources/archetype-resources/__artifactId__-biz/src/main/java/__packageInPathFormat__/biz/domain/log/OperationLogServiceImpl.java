#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.biz.domain.log;

import ${package}.biz.dao.OperationLogDao;
import ${package}.biz.dao.po.OperationLog;
import ${package}.biz.util.ConfigUtils;
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
