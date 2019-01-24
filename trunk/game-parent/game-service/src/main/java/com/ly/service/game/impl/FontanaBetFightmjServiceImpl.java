package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetFightmjMapper;
import com.ly.game.model.FontanaBetFightmj;
import com.ly.service.game.FontanaBetFightmjService;

@Service("fontanaBetFightmjService")
public class FontanaBetFightmjServiceImpl implements FontanaBetFightmjService {
	@Autowired
	private FontanaBetFightmjMapper fontanaBetFightmjMapper;

	@Override
	public int insert(FontanaBetFightmj record) {
		return fontanaBetFightmjMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetFightmj> list) {
		return fontanaBetFightmjMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetFightmj selectByPrimaryKey(Long id) {
		return fontanaBetFightmjMapper.selectByPrimaryKey(id);
	}
}