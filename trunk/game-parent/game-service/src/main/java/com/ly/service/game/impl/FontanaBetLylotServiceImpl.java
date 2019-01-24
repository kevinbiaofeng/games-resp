package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetLylotMapper;
import com.ly.game.model.FontanaBetLylot;
import com.ly.service.game.FontanaBetLylotService;

@Service("fontanaBetLylotService")
public class FontanaBetLylotServiceImpl implements FontanaBetLylotService {
	@Autowired
	private FontanaBetLylotMapper fontanaBetLylotMapper;

	@Override
	public int insert(FontanaBetLylot record) {
		return fontanaBetLylotMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetLylot> list) {
		return fontanaBetLylotMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetLylot selectByPrimaryKey(Long id) {
		return fontanaBetLylotMapper.selectByPrimaryKey(id);
	}
}