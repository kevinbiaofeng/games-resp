package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetFgdzMapper;
import com.ly.game.model.FontanaBetFgdz;
import com.ly.service.game.FontanaBetFgdzService;

@Service("fontanaBetFgdzService")
public class FontanaBetFgdzServiceImpl implements FontanaBetFgdzService {
	@Autowired
	private FontanaBetFgdzMapper fontanaBetFgdzMapper;

	@Override
	public int insert(FontanaBetFgdz record) {
		return fontanaBetFgdzMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetFgdz> list) {
		return fontanaBetFgdzMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetFgdz selectByPrimaryKey(Long id) {
		return fontanaBetFgdzMapper.selectByPrimaryKey(id);
	}
}