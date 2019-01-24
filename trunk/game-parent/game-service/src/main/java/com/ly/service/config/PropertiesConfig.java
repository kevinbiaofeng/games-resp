package com.ly.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component// 以组件的方式使用，使用的时候可以直接注入
@PropertySource(value= {"classpath:game-config.properties"},ignoreResourceNotFound=false,encoding="UTF-8")// 用来指定配置文件的位置
//@ConfigurationProperties(prefix="ly.games")// 用来指定properties配置文件中的key前缀
public class PropertiesConfig {
	@Value("${ly.games.ag.url}")
	private String agUrl;

	public String getAgUrl() {
		return agUrl;
	}

	public void setAgUrl(String agUrl) {
		this.agUrl = agUrl;
	}
	
	
}
