package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetPtgameMapper;
import com.ly.game.model.FontanaBetPtgame;
import com.ly.service.game.FontanaBetPtgameService;

@Service("fontanaBetPtgameService")
public class FontanaBetPtgameServiceImpl implements FontanaBetPtgameService {
	@Autowired
	private FontanaBetPtgameMapper fontanaBetPtgameMapper;

	@Override
	public int insert(FontanaBetPtgame record) {
		return fontanaBetPtgameMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetPtgame> list) {
		return fontanaBetPtgameMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetPtgame selectByPrimaryKey(Long id) {
		return fontanaBetPtgameMapper.selectByPrimaryKey(id);
	}
}