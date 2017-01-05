#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.biz.domain.log;


import ${package}.biz.dao.po.OperationLog;

public interface OperationLogService {

    void log(OperationLog operationLog);
}
