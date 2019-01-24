package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetSsMapper;
import com.ly.game.model.FontanaBetSs;
import com.ly.service.game.FontanaBetSsService;

@Service("fontanaBetSsService")
public class FontanaBetSsServiceImpl implements FontanaBetSsService {
	@Autowired
	private FontanaBetSsMapper fontanaBetSsMapper;

	@Override
	public int insert(FontanaBetSs record) {
		return fontanaBetSsMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetSs> list) {
		return fontanaBetSsMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetSs selectByPrimaryKey(Long id) {
		return fontanaBetSsMapper.selectByPrimaryKey(id);
	}
}