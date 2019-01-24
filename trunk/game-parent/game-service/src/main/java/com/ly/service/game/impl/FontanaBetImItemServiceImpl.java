package com.ly.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.game.mapper.FontanaBetImItemMapper;
import com.ly.game.model.FontanaBetImItem;
import com.ly.service.game.FontanaBetImItemService;

@Service("fontanaBetImItemService")
public class FontanaBetImItemServiceImpl implements FontanaBetImItemService {
	@Autowired
	private FontanaBetImItemMapper fontanaBetImItemMapper;

	@Override
	public int insert(FontanaBetImItem record) {
		return fontanaBetImItemMapper.insert(record);
	}

	@Override
	public int insertReplaceRecordBatch(List<FontanaBetImItem> list) {
		return fontanaBetImItemMapper.insertReplaceRecordBatch(list);
	}

	@Override
	public FontanaBetImItem selectByPrimaryKey(Long id) {
		return fontanaBetImItemMapper.selectByPrimaryKey(id);
	}
}