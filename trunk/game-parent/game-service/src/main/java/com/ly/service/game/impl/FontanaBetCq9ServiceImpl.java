package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetCq9Mapper;
import com.ly.game.model.FontanaBetCq9;
import com.ly.service.game.FontanaBetCq9Service;

@Service("fontanaBetCq9Service")
public class FontanaBetCq9ServiceImpl implements FontanaBetCq9Service {
	@Autowired
	private FontanaBetCq9Mapper fontanaBetCq9Mapper;

	@Override
	public int insert(FontanaBetCq9 record) {
		return fontanaBetCq9Mapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetCq9> list) {
		return fontanaBetCq9Mapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetCq9 selectByPrimaryKey(Long id) {
		return fontanaBetCq9Mapper.selectByPrimaryKey(id);
	}
}