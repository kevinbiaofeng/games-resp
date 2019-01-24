package com.ly.service.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ly.service.business.CQ9Service;

@RestController
public class CQ9RemoteApi {
	private final Logger logger =  LoggerFactory.getLogger(CQ9RemoteApi.class);
	
	@Autowired
	CQ9Service cq9Service;
	
	@RequestMapping(value="/cq9/load", method = RequestMethod.POST)
	@ResponseBody
	public void dataLoad() {
		cq9Service.loadingRemoteGameData();
	}
}
