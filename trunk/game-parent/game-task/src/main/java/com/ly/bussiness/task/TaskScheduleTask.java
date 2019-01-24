package com.ly.bussiness.task;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@DisallowConcurrentExecution
@Component
public class TaskScheduleTask implements Job {
	private static final Logger logger = LoggerFactory.getLogger(TaskScheduleTask.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		logger.info("task2....................");
	}

}