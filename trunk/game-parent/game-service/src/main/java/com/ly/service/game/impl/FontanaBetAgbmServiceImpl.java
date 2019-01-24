package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetAgbmMapper;
import com.ly.game.model.FontanaBetAgbm;
import com.ly.service.game.FontanaBetAgbmService;

@Service("fontanaBetAgbmService")
public class FontanaBetAgbmServiceImpl implements FontanaBetAgbmService {
	@Autowired
	private FontanaBetAgbmMapper fontanaBetAgbmMapper;

	@Override
	public int insert(FontanaBetAgbm record) {
		return fontanaBetAgbmMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetAgbm> list) {
		return fontanaBetAgbmMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetAgbm selectByPrimaryKey(Long id) {
		return fontanaBetAgbmMapper.selectByPrimaryKey(id);
	}

}
