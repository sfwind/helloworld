#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyJob {
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Scheduled(cron="${symbol_dollar}{dailyJob.cron}")
    public void work(){
        logger.info("DailyJob start");
        ${artifactId}();
        logger.info("DailyJob end");
    }

    private void ${artifactId}() {
        logger.info("hello world");
    }
}
