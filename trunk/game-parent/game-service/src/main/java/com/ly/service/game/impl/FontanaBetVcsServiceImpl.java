package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetVcsMapper;
import com.ly.game.model.FontanaBetVcs;
import com.ly.service.game.FontanaBetVcsService;

@Service("fontanaBetVcsService")
public class FontanaBetVcsServiceImpl implements FontanaBetVcsService {
	@Autowired
	private FontanaBetVcsMapper fontanaBetVcsMapper;

	@Override
	public int insert(FontanaBetVcs record) {
		return fontanaBetVcsMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetVcs> list) {
		return fontanaBetVcsMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetVcs selectByPrimaryKey(Long id) {
		return fontanaBetVcsMapper.selectByPrimaryKey(id);
	}
}