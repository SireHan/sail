package com.study.spring.sail.modules.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DefaultTaskSchedule {

    private Logger logger = LoggerFactory.getLogger(DefaultTaskSchedule.class);

    @Scheduled(fixedRate = 3600000)
    private void process(){
        logger.info("this is a default schedule task:"+(new Date()));
    }
}
