package com.ly.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ly.common.util.StringUtils;

@DisallowConcurrentExecution
@Component
public class TaskCenterJob implements Job {
    private Logger logger = LoggerFactory.getLogger(TaskCenterJob.class);

    @Override
    public void execute(JobExecutionContext executorContext) throws JobExecutionException {
        JobDataMap map = executorContext.getMergedJobDataMap();
        String jarPath = map.getString("jarPath");
        String parameter = map.getString("parameter");
        String vmParam = map.getString("vmParam");
        logger.info("Running Job name : {} ", map.getString("name"));
        logger.info("Running Job description : " + map.getString("JobDescription"));
        logger.info("Running Job group: {} ", map.getString("group"));
        logger.info("Running Job cron : " + map.getString("cronExpression"));
        logger.info("Running Job jar path : {} ", jarPath);
        logger.info("Running Job parameter : {} ", parameter);
        logger.info("Running Job vmParam : {} ", vmParam);
        long startTime = System.currentTimeMillis();
        if (!StringUtils.isEmpty(jarPath)) {
            File jar = new File(jarPath);
            if (jar.exists()) {
                ProcessBuilder processBuilder = new ProcessBuilder();
                processBuilder.directory(jar.getParentFile());
                List<String> commands = new ArrayList<>();
                commands.add("java");
                if (!StringUtils.isEmpty(vmParam)) commands.add(vmParam);
                commands.add("-jar");
                commands.add(jarPath);
                if (!StringUtils.isEmpty(parameter)) commands.add(parameter);
                processBuilder.command(commands);
                logger.info("Running Job details as follows >>>>>>>>>>>>>>>>>>>>: ");
                logger.info("Running Job commands : {}  ", StringUtils.getListString(commands));
                try {
                    Process process = processBuilder.start();
                    logProcess(process.getInputStream(), process.getErrorStream());
                } catch (IOException e) {
                    throw new JobExecutionException(e);
                }
            } else throw new JobExecutionException("Job Jar not found >>  " + jarPath);
        }
        long endTime = System.currentTimeMillis();
        logger.info(">>>>>>>>>>>>> Running Job has been completed , cost time :  " + (endTime - startTime) + "ms\n");
    }
    
    private void logProcess(InputStream inputStream, InputStream errorStream) throws IOException {
        String inputLine = null;
        String errorLine = null;
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream));
        while ((inputLine = inputReader.readLine()) != null) logger.info(inputLine);
        while ((errorLine = errorReader.readLine()) != null) logger.error(errorLine);
    }
}
