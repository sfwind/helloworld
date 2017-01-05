package com.iquanwai.helloworld.biz.domain.weixin.message;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;

@Data
public class TemplateMessage {
    private String touser;
    private String template_id;
    private String url;

    private Map<String, Keyword> data = Maps.newHashMap();

    @Data
    public static class Keyword{
        public Keyword(String value) {
            this.value = value;
        }

        private String value;
        private String color = "#44B549";
    }
}