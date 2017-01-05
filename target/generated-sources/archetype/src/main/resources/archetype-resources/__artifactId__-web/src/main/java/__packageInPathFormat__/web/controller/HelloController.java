#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.controller;

import ${package}.biz.dao.po.OperationLog;
import ${package}.biz.domain.log.OperationLogService;
import ${package}.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private OperationLogService operationLogService;


    @RequestMapping(value="/test2")
    public ResponseEntity<Map<String, Object>> printJson(@RequestParam("id") String id) {
        operationLogService.log(OperationLog.create().memo(id));

        return WebUtils.success();
    }
}
