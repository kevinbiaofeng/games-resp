package com.ly.bussiness.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ly.bussiness.fegin.CQ9FeginClient;

@DisallowConcurrentExecution
@Component
public class CQ9ScheduleTask implements Job{
	private static final Logger logger = LoggerFactory.getLogger(CQ9ScheduleTask.class);
	
	@Autowired
	CQ9FeginClient cq9FeginClient;
	
	@Override
	public void execute(JobExecutionContext executorContext) throws JobExecutionException {
		logger.info("CQ9 game task loading data starting time is: {}", dateFormat().format (new Date()));
		cq9FeginClient.dataLoad();
		logger.info("CQ9 game task loading data end time is: {}", dateFormat().format (new Date()));
    }
	
	private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
    }
}