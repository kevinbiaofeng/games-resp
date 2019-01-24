package com.ly.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GameRegisterCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameRegisterCenterApplication.class, args);
        System.out.println("【【【【【【 game-register-center 】】】】】】已启动.");
    }
}