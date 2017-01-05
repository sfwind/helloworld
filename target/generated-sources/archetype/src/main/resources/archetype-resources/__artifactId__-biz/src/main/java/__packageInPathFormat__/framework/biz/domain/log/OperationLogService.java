#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.framework.biz.domain.log;


import ${package}.framework.biz.dao.po.OperationLog;

public interface OperationLogService {

    void log(OperationLog operationLog);
}
