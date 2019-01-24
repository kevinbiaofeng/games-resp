package com.ly.bussiness.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.task.mapper.TaskJobEntityMapper;
import com.ly.task.model.TaskJobEntity;


@Service
public class TaskSchedulerService {
	@Autowired
    private TaskJobEntityMapper taskJobEntityMapper;

    public TaskJobEntity getTaskJobEntityById(Long id) {
        return taskJobEntityMapper.selectByPrimaryKey(id);
    }

    public List<TaskJobEntity> loadJobs() {
    	Map<String, Object> condition = new HashMap<String, Object>();
        List<TaskJobEntity> list = new ArrayList<>();
        taskJobEntityMapper.selectAllByCondition(condition).forEach(list::add);
        return list;
    }
    
    public JobDataMap getJobDataMap(TaskJobEntity job) {
        JobDataMap map = new JobDataMap();
        map.put("name", job.getName());
        map.put("group", job.getGroup());
        map.put("cronExpression", job.getCron());
        map.put("startDelay", job.getStartDelay());
        map.put("classPath", job.getClassPath());
        map.put("JobDescription", job.getDescription());
        map.put("status", job.getStatus());
        return map;
    }

    @SuppressWarnings("all")
	public JobDetail getJobDetail(JobKey jobKey, String description, JobDataMap map) throws ClassNotFoundException {
			Class clazz = Class.forName(map.getString("classPath"));
			return JobBuilder.newJob(clazz)
	                .withIdentity(jobKey)
	                .withDescription(description)
	                .setJobData(map)
	                .storeDurably()
	                .build();
    }

    public Trigger getTrigger(TaskJobEntity job) {
        return TriggerBuilder.newTrigger()
                .withIdentity(job.getName(), job.getGroup())
                .withSchedule(CronScheduleBuilder.cronSchedule(job.getCron()))
                .build();
    }

    public JobKey getJobKey(TaskJobEntity job) {
        return JobKey.jobKey(job.getName(), job.getGroup());
    }
}
