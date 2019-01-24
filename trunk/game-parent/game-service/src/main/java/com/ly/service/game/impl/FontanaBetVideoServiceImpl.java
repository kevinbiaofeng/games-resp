package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetVideoMapper;
import com.ly.game.model.FontanaBetVideo;
import com.ly.service.game.FontanaBetVideoService;

@Service("fontanaBetVideoService")
public class FontanaBetVideoServiceImpl implements FontanaBetVideoService {
	@Autowired
	private FontanaBetVideoMapper fontanaBetVideoMapper;

	@Override
	public int insert(FontanaBetVideo record) {
		return fontanaBetVideoMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetVideo> list) {
		return fontanaBetVideoMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetVideo selectByPrimaryKey(Long id) {
		return fontanaBetVideoMapper.selectByPrimaryKey(id);
	}
}