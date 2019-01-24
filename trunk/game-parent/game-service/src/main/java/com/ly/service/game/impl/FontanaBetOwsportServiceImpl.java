package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetOwsportMapper;
import com.ly.game.model.FontanaBetOwsport;
import com.ly.service.game.FontanaBetOwsportService;

@Service("fontanaBetOwsportService")
public class FontanaBetOwsportServiceImpl implements FontanaBetOwsportService {
	@Autowired
	private FontanaBetOwsportMapper fontanaBetOwsportMapper;

	@Override
	public int insert(FontanaBetOwsport record) {
		return fontanaBetOwsportMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetOwsport> list) {
		return fontanaBetOwsportMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetOwsport selectByPrimaryKey(Long id) {
		return fontanaBetOwsportMapper.selectByPrimaryKey(id);
	}
}