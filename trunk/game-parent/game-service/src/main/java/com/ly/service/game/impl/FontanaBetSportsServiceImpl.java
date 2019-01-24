package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetSportsMapper;
import com.ly.game.model.FontanaBetSports;
import com.ly.service.game.FontanaBetSportsService;

@Service("fontanaBetSportsService")
public class FontanaBetSportsServiceImpl implements FontanaBetSportsService {
	@Autowired
	private FontanaBetSportsMapper fontanaBetSportsMapper;

	@Override
	public int insert(FontanaBetSports record) {
		return fontanaBetSportsMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetSports> list) {
		return fontanaBetSportsMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetSports selectByPrimaryKey(Long id) {
		return fontanaBetSportsMapper.selectByPrimaryKey(id);
	}
}