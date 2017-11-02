package com.hirisun.springbootjsp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerService.class);

    @Scheduled(cron = "0/2 * * * * ?") // 每2秒执行一次
    public void scheduler() {
        LOGGER.debug("每2秒执行一次");
    }

    @Scheduled(cron = "0/4 * * * * ?") // 每2秒执行一次
    public void scheduler1() {
        LOGGER.debug("每4秒执行一次");
    }
}
