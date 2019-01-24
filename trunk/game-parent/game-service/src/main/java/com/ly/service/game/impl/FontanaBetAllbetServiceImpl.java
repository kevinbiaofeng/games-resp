package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetAllbetMapper;
import com.ly.game.model.FontanaBetAllbet;
import com.ly.service.game.FontanaBetAllbetService;

@Service("fontanaBetAllbetService")
public class FontanaBetAllbetServiceImpl implements FontanaBetAllbetService{
	@Autowired
	private FontanaBetAllbetMapper fontanaBetAllbetMapper;

	@Override
	public int insert(FontanaBetAllbet record) {
		return fontanaBetAllbetMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetAllbet> list) {
		return fontanaBetAllbetMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetAllbet selectByPrimaryKey(Long id) {
		return fontanaBetAllbetMapper.selectByPrimaryKey(id);
	}
}