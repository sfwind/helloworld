package com.iquanwai.helloworld.biz.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

public class QuaiwaiPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    @Override
    protected String resolvePlaceholder(String placeholder, Properties props) {
        return ConfigUtils.getValue(placeholder);
    }
}
