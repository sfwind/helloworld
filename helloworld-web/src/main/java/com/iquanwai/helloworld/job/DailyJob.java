package com.iquanwai.helloworld.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyJob {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Scheduled(cron="${dailyJob.cron}")
    public void work(){
        logger.info("DailyJob start");
        helloworld();
        logger.info("DailyJob end");
    }

    private void helloworld() {
        logger.info("hello world");
    }
}