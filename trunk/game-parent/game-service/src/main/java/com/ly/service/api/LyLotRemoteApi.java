package com.ly.service.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ly.service.business.LyLotService;

@RestController
public class LyLotRemoteApi {
	private final Logger logger =  LoggerFactory.getLogger(LyLotRemoteApi.class);
	
	@Autowired
	LyLotService lyLotService;
	
	@RequestMapping(value="/lyLot/load", method = RequestMethod.POST)
	@ResponseBody
	public void dataLoad() {
		lyLotService.loadingRemoteGameData();
	}
}
