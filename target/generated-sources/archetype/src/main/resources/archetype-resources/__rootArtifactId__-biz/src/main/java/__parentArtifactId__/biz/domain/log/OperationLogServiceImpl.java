#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.biz.domain.log;

import ${package}.${parentArtifactId}.biz.dao.OperationLogDao;
import ${package}.${parentArtifactId}.biz.dao.po.OperationLog;
import ${package}.${parentArtifactId}.biz.util.ConfigUtils;
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
