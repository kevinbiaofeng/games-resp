package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetFightnnMapper;
import com.ly.game.model.FontanaBetFightnn;
import com.ly.service.game.FontanaBetFightnnService;

@Service("fontanaBetFightnnService")
public class FontanaBetFightnnServiceImpl implements FontanaBetFightnnService {
	@Autowired
	private FontanaBetFightnnMapper fontanaBetFightnnMapper;

	@Override
	public int insert(FontanaBetFightnn record) {
		return fontanaBetFightnnMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetFightnn> list) {
		return fontanaBetFightnnMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetFightnn selectByPrimaryKey(Long id) {
		return fontanaBetFightnnMapper.selectByPrimaryKey(id);
	}
}