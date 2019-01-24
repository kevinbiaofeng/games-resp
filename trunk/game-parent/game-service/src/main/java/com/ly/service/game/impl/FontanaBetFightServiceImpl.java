package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetFightMapper;
import com.ly.game.model.FontanaBetFight;
import com.ly.service.game.FontanaBetFightService;

@Service("fontanaBetFightService")
public class FontanaBetFightServiceImpl implements FontanaBetFightService {
	@Autowired
	private FontanaBetFightMapper fontanaBetFightMapper;

	@Override
	public int insert(FontanaBetFight record) {
		return fontanaBetFightMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetFight> list) {
		return fontanaBetFightMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetFight selectByPrimaryKey(Long id) {
		return fontanaBetFightMapper.selectByPrimaryKey(id);
	}
}