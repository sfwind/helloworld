package com.iquanwai.framework.web.controller;

import com.iquanwai.framework.biz.dao.po.OperationLog;
import com.iquanwai.framework.biz.domain.log.OperationLogService;
import com.iquanwai.framework.web.util.WebUtils;
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
