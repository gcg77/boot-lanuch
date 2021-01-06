package com.boot.bootlanuch.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Thread.sleep;

/**
 * @author admin
 */
@Component
@Slf4j
public class ScheduledJobs {
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Scheduled(fixedDelay=2000)
    public void fixedDelayJob() throws InterruptedException{
        log.info("定时任务开始fixedDelay"+sdf.format(new Date()));
        long startTime=System.currentTimeMillis();
        sleep(1000);
        long endTime=System.currentTimeMillis();
        log.info("定时任务fixedDelay消耗时间："+(endTime-startTime)+"毫秒");
    }
    @Scheduled(fixedRate=2000)
    public void fixedRateJob() throws InterruptedException{
        log.info("定时任务开始fixedRate"+sdf.format(new Date()));
        long startTime=System.currentTimeMillis();
        sleep(1000);
        long endTime=System.currentTimeMillis();
        log.info("定时任务fixedRate消耗时间："+(endTime-startTime)+"毫秒");
    }
    @Scheduled(cron="0/1 * * * * ?")
    public void cronJob() throws InterruptedException{
        log.info("定时任务开始cron"+sdf.format(new Date()));
        long startTime=System.currentTimeMillis();
        sleep(1000);
        long endTime=System.currentTimeMillis();
        log.info("定时任务cron消耗时间："+(endTime-startTime)+"毫秒");
    }
}
