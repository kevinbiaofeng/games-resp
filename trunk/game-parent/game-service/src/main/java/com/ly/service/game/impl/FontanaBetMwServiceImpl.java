package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetMwMapper;
import com.ly.game.model.FontanaBetMw;
import com.ly.service.game.FontanaBetMwService;

@Service("fontanaBetMwService")
public class FontanaBetMwServiceImpl implements FontanaBetMwService {
	@Autowired
	private FontanaBetMwMapper fontanaBetMwMapper;

	@Override
	public int insert(FontanaBetMw record) {
		return fontanaBetMwMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetMw> list) {
		return fontanaBetMwMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetMw selectByPrimaryKey(Long id) {
		return fontanaBetMwMapper.selectByPrimaryKey(id);
	}
}