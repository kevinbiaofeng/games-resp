package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetSportsBwMapper;
import com.ly.game.model.FontanaBetSportsBw;
import com.ly.service.game.FontanaBetSportsBwService;

@Service("fontanaBetSportsBwService")
public class FontanaBetSportsBwServiceImpl implements FontanaBetSportsBwService {
	@Autowired
	private FontanaBetSportsBwMapper fontanaBetSportsBwMapper;

	@Override
	public int insert(FontanaBetSportsBw record) {
		return fontanaBetSportsBwMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetSportsBw> list) {
		return fontanaBetSportsBwMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetSportsBw selectByPrimaryKey(Long id) {
		return fontanaBetSportsBwMapper.selectByPrimaryKey(id);
	}
}