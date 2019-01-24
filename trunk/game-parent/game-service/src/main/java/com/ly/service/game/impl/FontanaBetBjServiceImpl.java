package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetBjMapper;
import com.ly.game.model.FontanaBetBj;
import com.ly.service.game.FontanaBetBjService;


@Service("fontanaBetBjService")
public class FontanaBetBjServiceImpl implements FontanaBetBjService{
	@Autowired
	private FontanaBetBjMapper fontanaBetBjMapper;

	@Override
	public int insert(FontanaBetBj record) {
		return fontanaBetBjMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetBj> list) {
		return fontanaBetBjMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetBj selectByPrimaryKey(Long id) {
		return fontanaBetBjMapper.selectByPrimaryKey(id);
	}
}