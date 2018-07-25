package com.xwtech.demo.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class QuartzService {

    @Scheduled(fixedRate = 5000)
    public  void TimeToNow(){
        Date date = new Date();
        log.info("定时任务开始了" +  date.getTime());
    }
}
