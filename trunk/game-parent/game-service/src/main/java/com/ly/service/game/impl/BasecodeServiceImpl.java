package com.ly.service.game.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBasecodeMapper;
import com.ly.game.model.FontanaBasecode;

@Service
public class BasecodeServiceImpl{
	@Autowired
	FontanaBasecodeMapper basecodeMapper;
	
	private String bcvalue;
	
	public String getBcvalue() {
		if(bcvalue==null||bcvalue.equals("")) {
			FontanaBasecode info=basecodeMapper.selectByPrimarybc("reportDbName","reportDbName");
			bcvalue= info.getBcvalue();
		}
		return bcvalue;
	}
}
