package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetFightcjMapper;
import com.ly.game.model.FontanaBetFightcj;
import com.ly.service.game.FontanaBetFightcjService;

@Service("fontanaBetFightcjService")
public class FontanaBetFightcjServiceImpl implements FontanaBetFightcjService {
	@Autowired
	private FontanaBetFightcjMapper fontanaBetFightcjMapper;

	@Override
	public int insert(FontanaBetFightcj record) {
		return fontanaBetFightcjMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetFightcj> list) {
		return fontanaBetFightcjMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetFightcj selectByPrimaryKey(Long id) {
		return fontanaBetFightcjMapper.selectByPrimaryKey(id);
	}
}