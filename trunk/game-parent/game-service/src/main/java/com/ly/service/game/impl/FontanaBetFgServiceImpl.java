package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetFgMapper;
import com.ly.game.model.FontanaBetFg;
import com.ly.service.game.FontanaBetFgService;

@Service("fontanaBetFgService")
public class FontanaBetFgServiceImpl implements FontanaBetFgService{
	@Autowired
	private FontanaBetFgMapper fontanaBetFgMapper;

	@Override
	public int insert(FontanaBetFg record) {
		return fontanaBetFgMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetFg> list) {
		return fontanaBetFgMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetFg selectByPrimaryKey(Long id) {
		return fontanaBetFgMapper.selectByPrimaryKey(id);
	}
}