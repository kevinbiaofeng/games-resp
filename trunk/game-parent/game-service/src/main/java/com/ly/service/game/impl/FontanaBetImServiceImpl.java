package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetImMapper;
import com.ly.game.model.FontanaBetIm;
import com.ly.service.game.FontanaBetImService;

@Service("fontanaBetImService")
public class FontanaBetImServiceImpl implements FontanaBetImService {
	@Autowired
	private FontanaBetImMapper fontanaBetImMapper;

	@Override
	public int insert(FontanaBetIm record) {
		return fontanaBetImMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetIm> list) {
		return fontanaBetImMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetIm selectByPrimaryKey(String id) {
		return fontanaBetImMapper.selectByPrimaryKey(id);
	}
}