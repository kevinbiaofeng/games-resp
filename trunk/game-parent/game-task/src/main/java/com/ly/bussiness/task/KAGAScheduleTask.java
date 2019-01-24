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

import com.ly.bussiness.fegin.KAGAFeginClient;

@DisallowConcurrentExecution
@Component
public class KAGAScheduleTask implements Job{
	private static final Logger logger = LoggerFactory.getLogger(KAGAScheduleTask.class);
	
	@Autowired
	KAGAFeginClient kagaFeginClient;
	
	@Override
	public void execute(JobExecutionContext executorContext) throws JobExecutionException {
		logger.info("KAGA game task loading data starting time is: {}", dateFormat().format (new Date()));
		kagaFeginClient.dataLoad();
		logger.info("KAGA game task loading data end time is: {}", dateFormat().format (new Date()));
    }
	
	private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
    }
}