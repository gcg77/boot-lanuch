package com.boot.bootlanuch.quartz;

import org.quartz.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class QuartzUtils {
    /**
     * 创建定时任务，定时任务创建后默认启动状态
     * @param scheduler
     * @param quartzBean
     * @throws ClassNotFoundException
     * @throws SchedulerException
     */
    public static void createScheduleJob(Scheduler scheduler,QuartzBean quartzBean) throws ClassNotFoundException, SchedulerException {
        //获取到定时任务的执行类，必须是类的绝对路径名称
        //定时任务类需要是job类的具体实现QuartzBean是job的抽象类
        Class<?extends Job> jobClass= (Class<? extends Job>) Class.forName(quartzBean.getJobClass());
        //构建定时任务信息
        JobDetail jboDetail= JobBuilder.newJob(jobClass).withIdentity(quartzBean.getJobName()).build();
        //设置定时任务执行方式
        CronScheduleBuilder scheduleBuilder=CronScheduleBuilder.cronSchedule(quartzBean.getCronExpression());
        //创建触发器
        CronTrigger cronTrigger=TriggerBuilder.newTrigger().withIdentity(quartzBean.getJobName()).withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jboDetail,cronTrigger);
    }

    /**
     * 根据任务名称暂停定时任务
     * @param scheduler
     * @param jobName
     * @throws SchedulerException
     */
    public static void pauseScheduleJob(Scheduler scheduler,String jobName) throws SchedulerException{
        JobKey jobKey=JobKey.jobKey(jobName);
        scheduler.pauseJob(jobKey);
    }

    /**
     * 暂停所有定时任务
     * @param scheduler
     * @throws SchedulerException
     */
    public static void pauseAllScheduleJob(Scheduler scheduler) throws SchedulerException{
        scheduler.pauseAll();
    }
    /**
     * 根据任务名立即恢复定时任务
     * @param scheduler
     * @param jobName
     * @throws SchedulerException
     */
    public static void resumeScheduleJob(Scheduler scheduler,String jobName) throws SchedulerException{
        JobKey jobKey=JobKey.jobKey(jobName);
        scheduler.resumeJob(jobKey);
    }

    /**
     * 恢复所有定时任务
     * @param scheduler
     * @throws SchedulerException
     */
    public static void resumeAllScheduleJob(Scheduler scheduler) throws SchedulerException{
        scheduler.resumeAll();
    }
    /**
     * 根据任务名立即运行一次任务
     * @param scheduler
     * @param jobName
     * @throws SchedulerException
     */
    public static void runOne(Scheduler scheduler,String jobName) throws SchedulerException{
        JobKey jobKey=JobKey.jobKey(jobName);
        scheduler.triggerJob(jobKey);
    }
    /**
     * 更新定时任务
     * @param scheduler
     * @param quartzBean
     * @throws ClassNotFoundException
     * @throws SchedulerException
     */
    public static void updateScheduleJob(Scheduler scheduler,QuartzBean quartzBean) throws ClassNotFoundException, SchedulerException {
        //获取到对应任务的触发器
        TriggerKey triggerKey=TriggerKey.triggerKey(quartzBean.getJobName());
        //设置定时任务执行方式
        CronScheduleBuilder scheduleBuilder=CronScheduleBuilder.cronSchedule(quartzBean.getCronExpression());
        //重新构建触发器
        CronTrigger cronTrigger= (CronTrigger) scheduler.getTrigger(triggerKey);
        cronTrigger=cronTrigger.getTriggerBuilder().withIdentity(quartzBean.getJobName()).withSchedule(scheduleBuilder).build();
        scheduler.rescheduleJob(triggerKey,cronTrigger);
    }

    /**
     * 删除定时任务
     * @param scheduler
     * @param jobName
     * @throws SchedulerException
     */
    public static void deleteScheduleJob(Scheduler scheduler,String jobName) throws SchedulerException{
        JobKey jobKey=JobKey.jobKey(jobName);
        scheduler.deleteJob(jobKey);
    }

    /**
     * 批量删除定时任务
     * @param scheduler
     * @param jobNameList
     * @throws SchedulerException
     */
    public static void deleteScheduleJobList(Scheduler scheduler, List<String> jobNameList) throws SchedulerException{
        List<JobKey> jobKeyList=new ArrayList<>();
        for(String jobName:jobNameList){
            JobKey jobKey=JobKey.jobKey(jobName);
            jobKeyList.add(jobKey);
        }
        scheduler.deleteJobs(jobKeyList);
    }
}
