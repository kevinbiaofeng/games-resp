package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetFightbrnnMapper;
import com.ly.game.model.FontanaBetFightbrnn;
import com.ly.service.game.FontanaBetFightbrnnService;

@Service("fontanaBetFightbrnnService")
public class FontanaBetFightbrnnServiceImpl implements FontanaBetFightbrnnService{
	@Autowired
	private FontanaBetFightbrnnMapper fontanaBetFightbrnnMapper;

	@Override
	public int insert(FontanaBetFightbrnn record) {
		return fontanaBetFightbrnnMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetFightbrnn> list) {
		return fontanaBetFightbrnnMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetFightbrnn selectByPrimaryKey(Long id) {
		return fontanaBetFightbrnnMapper.selectByPrimaryKey(id);
	}
}