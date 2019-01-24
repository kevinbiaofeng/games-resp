package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetEgameMapper;
import com.ly.game.model.FontanaBetEgame;
import com.ly.service.game.FontanaBetEgameService;

@Service("fontanaBetEgameService")
public class FontanaBetEgameServiceImpl implements FontanaBetEgameService {
	@Autowired
	private FontanaBetEgameMapper fontanaBetEgameMapper;

	@Override
	public int insert(FontanaBetEgame record) {
		return fontanaBetEgameMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetEgame> list) {
		return fontanaBetEgameMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetEgame selectByPrimaryKey(Long id) {
		return fontanaBetEgameMapper.selectByPrimaryKey(id);
	}
}