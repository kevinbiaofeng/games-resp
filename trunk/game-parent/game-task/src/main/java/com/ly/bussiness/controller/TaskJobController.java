package com.ly.bussiness.controller;

import java.util.Set;

import javax.annotation.PostConstruct;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ly.bussiness.service.TaskSchedulerService;
import com.ly.enums.SuccessStatusEnum;
import com.ly.task.model.TaskJobEntity;

@RestController
public class TaskJobController {
	private static final Logger logger = LoggerFactory.getLogger(TaskJobController.class);
	@Autowired
	private SchedulerFactoryBean factory;
	@Autowired
	private TaskSchedulerService schedulerService;

	/**
	   *  初始化启动所有的Job
	 */
	@PostConstruct
	public void initialize() throws Exception {
		try {
			restartAllJobs();
		} catch (SchedulerException e) {
			logger.error("Initialize Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	   *  根据ID重启某个Job
	 */
	@RequestMapping("/restart/{id}")
	public String restart(@PathVariable Long id) throws Exception {
		String result = null;
		TaskJobEntity entity = schedulerService.getTaskJobEntityById(id);
		if (entity == null) {
			return "error: id is not exist ";
		}
		TriggerKey triggerKey = new TriggerKey(entity.getName(), entity.getGroup());
		JobKey jobKey = schedulerService.getJobKey(entity);
		Scheduler scheduler = factory.getScheduler();
		try {
			scheduler.unscheduleJob(triggerKey);
			scheduler.deleteJob(jobKey);
			JobDataMap map = schedulerService.getJobDataMap(entity);
			JobDetail jobDetail = schedulerService.getJobDetail(jobKey, entity.getDescription(), map);
			if (entity.getStatus() == SuccessStatusEnum.SUCCESS.getCode()) {
				scheduler.startDelayed(map.getInt("startDelay"));
				scheduler.scheduleJob(jobDetail, schedulerService.getTrigger(entity));
				result = "Restart Job : " + entity.getName() + "\t success !";
			} else {
				result = "Restart Job : " + entity.getName() + "\t failed ! , " + "Because the Job status is " + entity.getStatus();
			}
		} catch (SchedulerException e) {
			result = "Error while Refresh " + e.getMessage();
		}
		return result;
	}

	/**
	   *  重启所有的Job
	 */
	@RequestMapping("/restart/all")
	public String restartAll() throws Exception {
		String result;
		try {
			restartAllJobs();
			result = "SUCCESS";
		} catch (SchedulerException e) {
			result = "EXCEPTION : " + e.getMessage();
		}
		return "Restart jobs : " + result;
	}

	/**
	   *  重新启动所有的job
	 */
	private void restartAllJobs() throws Exception {
		Scheduler scheduler = factory.getScheduler();
		Set<JobKey> set = scheduler.getJobKeys(GroupMatcher.anyGroup());
		for (JobKey jobKey : set) {
			scheduler.deleteJob(jobKey);
		}
		for (TaskJobEntity job : schedulerService.loadJobs()) {
			logger.info("Job register name : {} , group : {} , cron : {}", job.getName(), job.getGroup(), job.getCron());
			JobDataMap map = schedulerService.getJobDataMap(job);
			JobKey jobKey = schedulerService.getJobKey(job);
			JobDetail jobDetail = schedulerService.getJobDetail(jobKey, job.getDescription(), map);
			if (job.getStatus() == SuccessStatusEnum.SUCCESS.getCode()) {
				scheduler.startDelayed(map.getInt("startDelay"));
				scheduler.scheduleJob(jobDetail, schedulerService.getTrigger(job));
			}else {
				logger.info("Job jump name : {} , Because {} status is {}", job.getName(), job.getName(), job.getStatus());
			}
		}
	}
}
