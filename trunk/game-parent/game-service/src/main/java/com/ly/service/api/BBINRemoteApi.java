package com.ly.service.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ly.service.business.BBINService;

@RestController
public class BBINRemoteApi {
	private final Logger logger =  LoggerFactory.getLogger(BBINRemoteApi.class);
	
	@Autowired
	BBINService bbinService;
	
	@RequestMapping(value="/bbin/load", method = RequestMethod.POST)
	@ResponseBody
	public void dataLoad() {
		bbinService.loadingRemoteGameData();
	}
}
