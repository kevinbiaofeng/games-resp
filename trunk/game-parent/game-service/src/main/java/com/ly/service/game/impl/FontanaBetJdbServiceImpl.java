package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetJdbMapper;
import com.ly.game.model.FontanaBetJdb;
import com.ly.service.game.FontanaBetJdbService;

@Service("fontanaBetJdbService")
public class FontanaBetJdbServiceImpl implements FontanaBetJdbService {
	@Autowired
	private FontanaBetJdbMapper fontanaBetJdbMapper;

	@Override
	public int insert(FontanaBetJdb record) {
		return fontanaBetJdbMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetJdb> list) {
		return fontanaBetJdbMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetJdb selectByPrimaryKey(Long id) {
		return fontanaBetJdbMapper.selectByPrimaryKey(id);
	}
}