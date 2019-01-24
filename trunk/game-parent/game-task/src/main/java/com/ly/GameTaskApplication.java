package com.ly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.ly.config.RestTemplateConfig;

@SpringBootApplication
@MapperScan("com.ly.task.mapper")
@ServletComponentScan
@EnableFeignClients
@RibbonClient(name="game-service",configuration = RestTemplateConfig.class)
public class GameTaskApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GameTaskApplication.class, args);
		System.out.println("【【【【【【 game-task 已启动 】】】】】】");
	}

}