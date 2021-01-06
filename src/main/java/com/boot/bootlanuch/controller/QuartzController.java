package com.boot.bootlanuch.controller;


import com.boot.bootlanuch.async.ScheduledJobs;
import com.boot.bootlanuch.quartz.QuartzBean;
import com.boot.bootlanuch.quartz.QuartzUtils;
import com.boot.bootlanuch.response.RestResponse;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/quartz")
public class QuartzController {
    @Resource
    private Scheduler scheduler;
    @PostMapping("/create")
    public RestResponse createQuartzJob(@RequestBody QuartzBean quartzBean) throws ClassNotFoundException, SchedulerException {
        QuartzUtils.createScheduleJob(scheduler,quartzBean);
        return  RestResponse.success();
    }
    @PostMapping("/runone")
    public RestResponse runOne(@RequestBody QuartzBean quartzBean) throws ClassNotFoundException, SchedulerException {
        QuartzUtils.runOne(scheduler,quartzBean.getJobName());
        return  RestResponse.success();
    }
    @PostMapping("/pause")
    public RestResponse pauseJob(@RequestBody QuartzBean quartzBean) throws ClassNotFoundException, SchedulerException {
        QuartzUtils.pauseScheduleJob(scheduler,quartzBean.getJobName());
        return  RestResponse.success();
    }
    @PostMapping("/update")
    public RestResponse updateJob(@RequestBody QuartzBean quartzBean) throws ClassNotFoundException, SchedulerException {
        QuartzUtils.updateScheduleJob(scheduler,quartzBean);
        return  RestResponse.success();
    }
    @PostMapping("/resume")
    public RestResponse resumeJob(@RequestBody QuartzBean quartzBean) throws ClassNotFoundException, SchedulerException {
        QuartzUtils.resumeScheduleJob(scheduler,quartzBean.getJobName());
        return  RestResponse.success();
    }

}
