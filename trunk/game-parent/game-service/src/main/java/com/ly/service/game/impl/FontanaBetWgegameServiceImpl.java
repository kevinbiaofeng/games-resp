package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetWgegameMapper;
import com.ly.game.model.FontanaBetWgegame;
import com.ly.service.game.FontanaBetWgegameService;

@Service("fontanaBetWgegameService")
public class FontanaBetWgegameServiceImpl implements FontanaBetWgegameService {
	@Autowired
	private FontanaBetWgegameMapper fontanaBetWgegameMapper;

	@Override
	public int insert(FontanaBetWgegame record) {
		return fontanaBetWgegameMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetWgegame> list) {
		return fontanaBetWgegameMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetWgegame selectByPrimaryKey(Long id) {
		return fontanaBetWgegameMapper.selectByPrimaryKey(id);
	}
}