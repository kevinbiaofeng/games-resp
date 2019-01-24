package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetBbinfishingMapper;
import com.ly.game.model.FontanaBetBbinfishing;
import com.ly.service.game.FontanaBetBbinfishingService;

@Service("fontanaBetBbinfishingService")
public class FontanaBetBbinfishingServiceImpl implements FontanaBetBbinfishingService{
	@Autowired
	private FontanaBetBbinfishingMapper fontanaBetBbinfishingMapper;

	@Override
	public int insert(FontanaBetBbinfishing record) {
		return fontanaBetBbinfishingMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetBbinfishing> list) {
		return fontanaBetBbinfishingMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetBbinfishing selectByPrimaryKey(Long id) {
		return fontanaBetBbinfishingMapper.selectByPrimaryKey(id);
	}
}