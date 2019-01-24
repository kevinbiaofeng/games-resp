package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetBoinsportMapper;
import com.ly.game.model.FontanaBetBoinsport;
import com.ly.service.game.FontanaBetBoinsportService;

@Service("fontanaBetBoinsportService")
public class FontanaBetBoinsportServiceImpl implements FontanaBetBoinsportService{
	@Autowired
	private FontanaBetBoinsportMapper fontanaBetBoinsportMapper;

	@Override
	public int insert(FontanaBetBoinsport record) {
		return fontanaBetBoinsportMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetBoinsport> list) {
		return fontanaBetBoinsportMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetBoinsport selectByPrimaryKey(Long id) {
		return fontanaBetBoinsportMapper.selectByPrimaryKey(id);
	}
}