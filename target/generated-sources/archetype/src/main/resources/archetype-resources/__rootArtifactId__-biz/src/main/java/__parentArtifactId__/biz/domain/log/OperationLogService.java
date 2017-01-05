#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${parentArtifactId}.biz.domain.log;


import ${package}.${parentArtifactId}.biz.dao.po.OperationLog;

public interface OperationLogService {

    void log(OperationLog operationLog);
}
