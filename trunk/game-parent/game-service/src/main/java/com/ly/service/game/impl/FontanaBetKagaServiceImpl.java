package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetKagaMapper;
import com.ly.game.model.FontanaBetKaga;
import com.ly.service.game.FontanaBetKagaService;

@Service("fontanaBetKagaService")
public class FontanaBetKagaServiceImpl implements FontanaBetKagaService {
	@Autowired
	private FontanaBetKagaMapper fontanaBetKagaMapper;

	@Override
	public int insert(FontanaBetKaga record) {
		return fontanaBetKagaMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetKaga> list) {
		return fontanaBetKagaMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetKaga selectByPrimaryKey(Long id) {
		return fontanaBetKagaMapper.selectByPrimaryKey(id);
	}
}