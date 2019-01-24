package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetSunbetMapper;
import com.ly.game.model.FontanaBetSunbet;
import com.ly.service.game.FontanaBetSunbetService;

@Service("fontanaBetSunbetService")
public class FontanaBetSunbetServiceImpl implements FontanaBetSunbetService {
	@Autowired
	private FontanaBetSunbetMapper fontanaBetSunbetMapper;

	@Override
	public int insert(FontanaBetSunbet record) {
		return fontanaBetSunbetMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetSunbet> list) {
		return fontanaBetSunbetMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetSunbet selectByPrimaryKey(Long id) {
		return fontanaBetSunbetMapper.selectByPrimaryKey(id);
	}
}